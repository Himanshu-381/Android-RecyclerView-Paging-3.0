package com.androidpaginationexample.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.androidpaginationexample.data.database.Database
import com.androidpaginationexample.data.Post
import com.androidpaginationexample.data.RemoteKeys
import com.androidpaginationexample.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class PostsRemoteMediator constructor(
    private val db: Database,
    private val apiService: ApiService
) : RemoteMediator<Int, Post>() {
    private val STARTING_PAGE_INDEX = 1

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Post>): MediatorResult {
        val pageKeyData = getKeyPageData(loadType, state)
        val page = when (pageKeyData) {
            is MediatorResult.Success -> {
                return pageKeyData
            }

            else -> {
                pageKeyData as Int
            }
        }

        try {
            val response = apiService.getAllPosts(page)
            val endOfList = response.isEmpty()
            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.remoteKeyDao().clearAll()
                    db.getDao().clearAll()
                }
                val prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1
                val nextKey = if (endOfList) null else page + 1
                val keys = response.map {
                    RemoteKeys(it.id.toString(), prevKey, nextKey)
                }
                db.remoteKeyDao().insertRemote(keys)
                db.getDao().insert(response)
            }
            return MediatorResult.Success(endOfPaginationReached = endOfList)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }


    private suspend fun getKeyPageData(loadType: LoadType, state: PagingState<Int, Post>): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getRefreshRemoteKey(state)
                remoteKeys?.nextKey?.minus(1) ?: STARTING_PAGE_INDEX
            }

            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
                val prevKey = remoteKeys?.prevKey ?: MediatorResult.Success(
                    endOfPaginationReached = false
                )
                prevKey
            }

            LoadType.APPEND -> {
                val remoteKeys = getLastRemoteKey(state)
                val nextKey = remoteKeys?.nextKey ?: MediatorResult.Success(
                    endOfPaginationReached = true
                )
                nextKey
            }
        }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, Post>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.pages
                .firstOrNull { it.data.isNotEmpty() }
                ?.data?.firstOrNull()
                ?.let { post -> db.remoteKeyDao().getRemoteKeys(post.id.toString()) }
        }
    }

    private suspend fun getLastRemoteKey(state: PagingState<Int, Post>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.pages
                .lastOrNull { it.data.isNotEmpty() }
                ?.data?.lastOrNull()
                ?.let { post ->
                    db.remoteKeyDao().getRemoteKeys(post.id.toString())
                }
        }
    }

    private suspend fun getRefreshRemoteKey(state: PagingState<Int, Post>): RemoteKeys? {
        return withContext(Dispatchers.IO) {
            state.anchorPosition?.let { position ->
                state.closestItemToPosition(position)?.id?.let { repId ->
                    db.remoteKeyDao().getRemoteKeys(repId.toString())
                }
            }
        }
    }

}
