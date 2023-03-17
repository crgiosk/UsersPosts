package com.pruebadeingreso.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pruebadeingreso.data.local.entities.PostEntity

@Dao
interface PostDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(post: PostEntity)

    @Query("SELECT * FROM posts WHERE user_id = :isUSer")
    fun getPostByUserId(isUSer: Long): List<PostEntity>

}