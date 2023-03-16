package com.pruebadeingreso.data.network.clients

import com.pruebadeingreso.data.network.models.user.UserApiResponse
import retrofit2.Response
import retrofit2.http.GET


interface UserApiClient {

    @GET("/users")
    suspend fun getAllUsers(): Response<List<UserApiResponse>>
}