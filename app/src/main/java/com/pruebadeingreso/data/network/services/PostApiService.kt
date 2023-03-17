package com.pruebadeingreso.data.network.services

import com.pruebadeingreso.data.network.models.post.PostApiResponse
import com.pruebadeingreso.data.network.models.user.UserApiResponse
import com.pruebadeingreso.data.network.user.PostApiClient
import com.pruebadeingreso.data.network.user.UserApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PostApiService @Inject constructor(
    private val postApiClient: PostApiClient
) {

    suspend fun getPostByUser(idUser: Int): List<PostApiResponse> {
        return withContext(Dispatchers.IO) {
            val response = postApiClient.getPostsByUserId(idUser)
            response
        }
    }
}