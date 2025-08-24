package com.users_posts.data.repositories

import com.users_posts.data.network.services.PostApiService
import com.users_posts.ui.binds.PostUserBind
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postApiService: PostApiService
): PostRepository {


    override suspend fun getPostByUser(idUser: Int): List<PostUserBind> {
        return postApiService.getPostByUser(idUser).map { it.toBind() }
    }

}