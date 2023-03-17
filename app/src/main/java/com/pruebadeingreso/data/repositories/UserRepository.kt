package com.pruebadeingreso.data.repositories

import com.pruebadeingreso.data.local.daos.UserDAO
import com.pruebadeingreso.data.local.entities.UserEntity
import com.pruebadeingreso.data.network.models.user.UserApiResponse
import com.pruebadeingreso.data.network.services.UserApiService
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
}