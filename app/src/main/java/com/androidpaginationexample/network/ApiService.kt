package com.androidpaginationexample.network

import com.androidpaginationexample.data.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getAllPosts(
        @Query("_page") page:Int) : List<Post>
}