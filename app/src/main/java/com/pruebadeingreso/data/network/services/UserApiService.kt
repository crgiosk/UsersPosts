package com.pruebadeingreso.data.network.services

import com.pruebadeingreso.data.network.user.UserApiClient
import com.pruebadeingreso.data.network.models.user.UserApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserApiService @Inject constructor(
    private val apiClient: UserApiClient
) {

    suspend fun getAllUsers(): List<UserApiResponse> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getAllUsers()
            response.body() ?: emptyList()
        }
    }
}