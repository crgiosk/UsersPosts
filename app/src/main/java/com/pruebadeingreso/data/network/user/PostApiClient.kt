package com.pruebadeingreso.data.network.user

import com.pruebadeingreso.data.network.models.post.PostApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApiClient {

    @GET("/posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): List<PostApiResponse>

}