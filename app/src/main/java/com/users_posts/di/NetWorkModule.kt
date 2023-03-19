package com.users_posts.di

import com.users_posts.data.network.user.PostApiClient
import com.users_posts.data.network.user.UserApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    private const val URL_BASE = "https://jsonplaceholder.typicode.com"

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): UserApiClient =
        retrofit.create(UserApiClient::class.java)

    @Singleton
    @Provides
    fun providePostApiClient(retrofit: Retrofit): PostApiClient =
        retrofit.create(PostApiClient::class.java)

}