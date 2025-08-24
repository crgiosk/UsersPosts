package com.users_posts.data.repositories

import com.users_posts.data.local.daos.UserDAO
import com.users_posts.data.local.entities.UserEntity
import com.users_posts.data.network.models.user.UserApiResponse
import com.users_posts.data.network.services.UserAPIService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserAPIService,
    private val userDAO: UserDAO
): UserRepository {

    override suspend fun getUsersFromApi(): List<UserApiResponse> {
           return userApiService.getAllUsers()
    }

    override suspend fun getAllUsersLocal(): List<UserEntity> {
        return userDAO.getAllUsers()
    }

    override suspend fun saverUsers(users: List<UserEntity>) {
        userDAO.insertUsers(users)
    }

    override suspend fun searchUserByName(name: String): List<UserEntity> {
        return userDAO.searchUserByName(name)
    }
}