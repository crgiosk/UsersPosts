package com.pruebadeingreso.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.pruebadeingreso.data.local.entities.PostsByUser
import com.pruebadeingreso.data.local.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(user: List<UserEntity>)

    @Query("SELECT * FROM user WHERE name LIKE :name || '%' ORDER BY name ASC")
    suspend fun searchUserByName(name: String): List<UserEntity>

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user")
    suspend fun subscribeUsers(): List<UserEntity>

    @Transaction
    @Query("SELECT * FROM user")
    suspend fun getUserWithPosts(): List<PostsByUser>

}