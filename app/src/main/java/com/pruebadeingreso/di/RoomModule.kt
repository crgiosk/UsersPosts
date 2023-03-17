package com.pruebadeingreso.di

import android.content.Context
import androidx.room.Room
import com.pruebadeingreso.data.local.UserPostDatabase
import com.pruebadeingreso.data.local.daos.PostDAO
import com.pruebadeingreso.data.local.daos.UserDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val USER_POST_DATABASE_NAME = "user_posts_db"

    @Singleton
    @Provides
    fun getDatabaseInstance(@ApplicationContext context: Context): UserPostDatabase {
        return Room
            .databaseBuilder(context, UserPostDatabase::class.java, USER_POST_DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun getUserDAOInstance(dataBase: UserPostDatabase): UserDAO = dataBase.getUserDAO()

    @Singleton
    @Provides
    fun getPostDAOInstance(dataBase: UserPostDatabase): PostDAO = dataBase.getPostDAO()

}