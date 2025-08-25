package com.users_posts.data.repositories

import com.users_posts.data.network.models.post.PostApiResponse
import com.users_posts.data.network.services.PostApiService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class PostRepositoryImplTest {

    @RelaxedMockK
    lateinit var postApiService: PostApiService

    lateinit var repository: PostRepositoryImpl

    @Before
    fun onStart() {
        MockKAnnotations.init(this)
        repository = PostRepositoryImpl(postApiService)
    }

    @Test
    fun `Validate getPostByUser not empty data`() = runTest {
        val response = listOf(
            PostApiResponse(
                body = "body",
                id = 1,
                title = "title",
                userId = 1
            )
        )
        coEvery {
            postApiService.getPostByUser(1)
        } returns response

        val result = repository.getPostByUser(1)

        assert(result.isNotEmpty())

    }

    @Test
    fun `Validate getPostByUser empty data`() = runTest {
        coEvery {
            postApiService.getPostByUser(1)
        } returns emptyList()

        val result = repository.getPostByUser(1)

        assert(result.isEmpty())

    }
}