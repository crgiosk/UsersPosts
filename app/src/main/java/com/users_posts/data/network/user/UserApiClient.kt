package com.users_posts.data.network.user

import com.users_posts.data.network.models.user.UserApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("/users")
    suspend fun getAllUsers(): Response<List<UserApiResponse>>
}