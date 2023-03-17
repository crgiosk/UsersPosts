package com.pruebadeingreso.data.repositories

import com.pruebadeingreso.data.network.models.post.PostApiResponse
import com.pruebadeingreso.data.network.services.PostApiService
import com.pruebadeingreso.ui.binds.PostUserBind
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postApiService: PostApiService
) {


    suspend fun getPostByUser(idUser: Int): List<PostUserBind> {
        return postApiService.getPostByUser(idUser).map { it.toBind() }
    }

    //todo!! create function to consultUser from db
}