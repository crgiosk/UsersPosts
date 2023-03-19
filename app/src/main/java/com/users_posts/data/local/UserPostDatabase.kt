package com.users_posts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.users_posts.data.local.daos.PostDAO
import com.users_posts.data.local.daos.UserDAO
import com.users_posts.data.local.entities.PostEntity
import com.users_posts.data.local.entities.UserEntity

@Database(
    entities = [
        UserEntity::class,
        PostEntity::class
    ],
    version = 1
)
abstract class UserPostDatabase : RoomDatabase() {

    abstract fun getUserDAO(): UserDAO

    abstract fun getPostDAO(): PostDAO
}