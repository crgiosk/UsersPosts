package com.users_posts.data.network.services

import com.users_posts.data.network.models.post.PostApiResponse

interface PostApiService {

    suspend fun getPostByUser(idUser: Int): List<PostApiResponse>

}