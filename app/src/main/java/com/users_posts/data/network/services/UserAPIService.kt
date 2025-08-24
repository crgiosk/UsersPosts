package com.users_posts.data.network.services

import com.users_posts.data.network.models.user.UserApiResponse

interface UserAPIService {
    suspend fun getAllUsers(): List<UserApiResponse>
}