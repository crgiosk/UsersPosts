package com.users_posts.data.repositories

import com.users_posts.ui.binds.PostUserBind

interface PostRepository {
    suspend fun getPostByUser(idUser: Int): List<PostUserBind>
}