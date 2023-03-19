package com.users_posts.data.network.models.user

import com.google.gson.annotations.SerializedName
import com.users_posts.data.local.entities.UserEntity

data class UserApiResponse(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String
) {
    fun toEntity(): UserEntity {
        return UserEntity(
            userId = id,
            name = name,
            phone = phone,
            email = email
        )
    }
}