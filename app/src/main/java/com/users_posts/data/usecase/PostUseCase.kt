package com.users_posts.data.usecase

import com.users_posts.data.repositories.PostRepository
import com.users_posts.ui.binds.PostUserBind
import javax.inject.Inject

class PostUseCase @Inject constructor(
    private val repository: PostRepository
) {

    suspend fun getPostByUser(idUser: Int): List<PostUserBind> {
        return repository.getPostByUser(idUser)
    }

}