package com.pruebadeingreso.data.usecase

import com.pruebadeingreso.data.repositories.PostRepository
import com.pruebadeingreso.ui.binds.PostUserBind
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PostUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: PostRepository

    private lateinit var useCase: PostUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        useCase = PostUseCase(repository)
    }

    @Test
    fun `when the api return data successfully`() = runBlocking {
        val idUser = 1
        val myList = mutableListOf(
            PostUserBind(
                idUser,
                "AnyTitle",
                "orem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel dictum orci. Aliquam ut nunc eget eros accumsan varius vel et arcu. In tempor odio at dui auctor, eu fringilla ligula accumsan."
            )
        )

        coEvery { repository.getPostByUser(idUser) } returns myList

        val response = useCase.getPostByUser(idUser)

        assertEquals(response, myList)
        assertTrue(response.isNotEmpty())
    }

}