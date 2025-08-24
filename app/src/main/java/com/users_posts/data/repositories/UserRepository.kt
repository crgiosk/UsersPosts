package com.users_posts.data.repositories

import com.users_posts.data.local.entities.UserEntity
import com.users_posts.data.network.models.user.UserApiResponse

interface UserRepository {

    suspend fun getUsersFromApi(): List<UserApiResponse>

    suspend fun getAllUsersLocal(): List<UserEntity>

    suspend fun saverUsers(users: List<UserEntity>)

    suspend fun searchUserByName(name: String): List<UserEntity>

}