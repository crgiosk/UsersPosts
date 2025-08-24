package com.users_posts.di

import com.users_posts.data.network.services.PostApiServiceImpl
import com.users_posts.data.network.services.PostApiService
import com.users_posts.data.network.user.PostApiClient
import com.users_posts.data.repositories.PostRepository
import com.users_posts.data.repositories.PostRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class PostModule {

    @Singleton
    @Provides
    fun providesPostAPIService(postApiClient: PostApiClient): PostApiService {
        return PostApiServiceImpl(postApiClient)
    }

    @Singleton
    @Provides
    fun providesPostRepository(postApiService: PostApiService): PostRepository {
        return PostRepositoryImpl(postApiService)
    }



}