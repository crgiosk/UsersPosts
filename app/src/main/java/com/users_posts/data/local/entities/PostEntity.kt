package com.users_posts.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "posts",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [UserEntity.NAME_COLUM_ID],
            childColumns = [PostEntity.NAME_COLUM_FK_USER],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String,
    @ColumnInfo(name = NAME_COLUM_FK_USER, index = true)
    val userId: Long
) {
    companion object {
        const val NAME_TABLE = "post"
        const val NAME_COLUM_FK_USER = "user_id"
    }
}