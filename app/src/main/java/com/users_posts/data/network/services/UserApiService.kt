package com.users_posts.data.network.services

import com.users_posts.data.network.user.UserApiClient
import com.users_posts.data.network.models.user.UserApiResponse
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