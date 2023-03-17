package com.pruebadeingreso.data.usecase

import com.pruebadeingreso.data.network.models.post.PostApiResponse
import com.pruebadeingreso.data.repositories.PostRepository
import com.pruebadeingreso.ui.binds.PostUserBind
import javax.inject.Inject

class PostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    //todo!! this functions should return list
    //its mean Db or Api service
    //

    suspend fun getPostByUser(idUser: Int): List<PostUserBind> {
        return repository.getPostByUser(idUser)
    }

}