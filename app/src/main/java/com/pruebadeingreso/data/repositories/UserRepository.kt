package com.pruebadeingreso.data.repositories

import com.pruebadeingreso.data.network.services.UserApiService
import com.pruebadeingreso.ui.binds.UserBind
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userApiService: UserApiService
) {

    suspend fun getAllUsers(): List<UserBind> {
        return userApiService.getAllUsers().map { it.toBind() }
    }

    //todo!! create function to consultUser from db
}