package com.users_posts.data.network.models.post

import com.google.gson.annotations.SerializedName
import com.users_posts.ui.binds.PostUserBind

data class PostApiResponse(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
) {
    fun toBind(): PostUserBind {
        return PostUserBind(
            idUser = userId,
            title = title,
            body = body
        )
    }
}