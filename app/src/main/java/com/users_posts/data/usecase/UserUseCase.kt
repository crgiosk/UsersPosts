package com.users_posts.data.usecase

import com.users_posts.data.repositories.UserRepository
import com.users_posts.ui.binds.UserBind
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(): List<UserBind> {
        val dataFromBd = userRepository.getAllUsersLocal()
        return if (dataFromBd.isEmpty()) {
            userRepository.saverUsers(
                userRepository.getUsersFromApi().map { it.toEntity() }
            )
            userRepository.getAllUsersLocal().map { it.toBind() }
        } else {
            dataFromBd.map { it.toBind() }
        }
    }

    suspend fun searchUserByName(name: String): List<UserBind> {
        return userRepository.searchUserByName(name).map { it.toBind() }
    }
}