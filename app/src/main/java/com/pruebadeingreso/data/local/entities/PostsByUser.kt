package com.pruebadeingreso.data.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class PostsByUser(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = UserEntity.NAME_COLUM_ID,
        entityColumn = PostEntity.NAME_COLUM_FK_USER
    )
    val posts: List<PostEntity>
)