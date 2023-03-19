package com.users_posts.data.network.user

import com.users_posts.data.network.models.post.PostApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApiClient {

    @GET("/posts")
    suspend fun getPostsByUserId(@Query("userId") userId: Int): List<PostApiResponse>

}