package com.androidpaginationexample.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.androidpaginationexample.data.Post

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<Post>)

    @Query("SELECT * FROM posts")
    fun getAllPosts():PagingSource<Int, Post>

    @Query("DELETE FROM posts")
    fun clearAll()
}