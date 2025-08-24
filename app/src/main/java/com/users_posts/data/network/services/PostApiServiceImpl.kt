package com.users_posts.data.network.services

import com.users_posts.data.network.models.post.PostApiResponse
import com.users_posts.data.network.user.PostApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostApiServiceImpl @Inject constructor(
    private val postApiClient: PostApiClient
): PostApiService {

    override suspend fun getPostByUser(idUser: Int): List<PostApiResponse> {
        return withContext(Dispatchers.IO) {
            val response = postApiClient.getPostsByUserId(idUser)
            response
        }
    }
}