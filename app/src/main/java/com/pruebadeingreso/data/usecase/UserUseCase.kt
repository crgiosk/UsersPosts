package com.pruebadeingreso.data.usecase

import com.pruebadeingreso.data.repositories.UserRepository
import com.pruebadeingreso.ui.binds.UserBind
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    //todo!! this functions should return list
    //its mean Db or Api service
    //
    suspend operator fun invoke(): List<UserBind> {
        return userRepository.getAllUsers()
    }
}