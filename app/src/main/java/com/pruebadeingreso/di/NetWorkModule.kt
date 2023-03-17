package com.pruebadeingreso.di

import com.pruebadeingreso.data.network.user.PostApiClient
import com.pruebadeingreso.data.network.user.UserApiClient
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

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
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