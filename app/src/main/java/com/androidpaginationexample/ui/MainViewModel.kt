package com.androidpaginationexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.androidpaginationexample.data.database.Database
import com.androidpaginationexample.data.Post
import com.androidpaginationexample.data.repository.PostsRemoteMediator
import com.androidpaginationexample.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(private val db:Database,private val apiService: ApiService) : ViewModel() {

    @ExperimentalPagingApi
    fun getAllPosts() : Flow<PagingData<Post>> = Pager(
        config = PagingConfig(20),
        pagingSourceFactory = {db.getDao().getAllPosts()},
        remoteMediator = PostsRemoteMediator(db,apiService)
    ).flow.cachedIn(viewModelScope)
}