package com.users_posts.di

import com.users_posts.data.local.daos.UserDAO
import com.users_posts.data.network.services.UserAPIService
import com.users_posts.data.network.services.UserApiServiceImpl
import com.users_posts.data.network.user.UserApiClient
import com.users_posts.data.repositories.UserRepository
import com.users_posts.data.repositories.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Singleton
    @Provides
    fun providesUserAPIService(
        apiClient: UserApiClient
    ): UserAPIService {
        return UserApiServiceImpl(apiClient)
    }

    @Singleton
    @Provides
    fun providesUserRepository(
        userApiService: UserAPIService,
        userDAO: UserDAO
    ): UserRepository {
        return UserRepositoryImpl(userApiService, userDAO)
    }
}