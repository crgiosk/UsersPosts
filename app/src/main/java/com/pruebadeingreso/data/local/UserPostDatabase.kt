package com.pruebadeingreso.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pruebadeingreso.data.local.daos.PostDAO
import com.pruebadeingreso.data.local.daos.UserDAO
import com.pruebadeingreso.data.local.entities.PostEntity
import com.pruebadeingreso.data.local.entities.UserEntity

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