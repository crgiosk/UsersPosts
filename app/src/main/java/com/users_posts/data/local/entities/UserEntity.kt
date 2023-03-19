package com.users_posts.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.users_posts.ui.binds.UserBind

@Entity(tableName = UserEntity.NAME_TABLE)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NAME_COLUM_ID)
    val id: Int = 0,

    @ColumnInfo(name = "user_id")
    val userId: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "email")
    val email: String
) {

    fun toBind(): UserBind {
        return UserBind(
            idUser = id,
            name = name,
            numberPhone = phone,
            email = email
        )
    }

    companion object {
        const val NAME_TABLE = "user"
        const val NAME_COLUM_ID = "id"
    }
}