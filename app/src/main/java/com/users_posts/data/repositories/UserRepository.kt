package com.users_posts.data.repositories

import com.users_posts.data.local.daos.UserDAO
import com.users_posts.data.local.entities.UserEntity
import com.users_posts.data.network.models.user.UserApiResponse
import com.users_posts.data.network.services.UserApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApiService: UserApiService,
    private val userDAO: UserDAO
) {

    suspend fun getUsersFromApi(): List<UserApiResponse> {
           return userApiService.getAllUsers()
    }

    suspend fun getAllUsersLocal(): List<UserEntity> {
        return userDAO.getAllUsers()
    }

    suspend fun saverUsers(users: List<UserEntity>) {
        userDAO.insertUsers(users)
    }

    suspend fun searchUserByName(name: String): List<UserEntity> {
        return userDAO.searchUserByName(name)
    }
}