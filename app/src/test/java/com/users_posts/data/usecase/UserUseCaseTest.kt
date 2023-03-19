package com.users_posts.data.usecase


import com.users_posts.data.local.entities.UserEntity
import com.users_posts.data.network.models.user.UserApiResponse
import com.users_posts.data.repositories.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UserUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: UserRepository

    private lateinit var useCase: UserUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        useCase = UserUseCase(repository)
    }

    @Test
    fun `when local db isEmpty and api is called`() = runBlocking {
        val apiUsers = listOf(
            UserApiResponse(
                id = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            ),
            UserApiResponse(
                id = 2,
                name = "Jane",
                email = "email.Jane@fakemail.com",
                phone = "25555502"
            )
        )
        coEvery { repository.getAllUsersLocal() } returns emptyList()
        coEvery { repository.getUsersFromApi() } returns apiUsers

        val savedUsers = apiUsers.map { it.toEntity() }
        coEvery { repository.saverUsers(savedUsers) } returns Unit


        useCase()
        coVerify (exactly = 1) { repository.getUsersFromApi() }
        coVerify (exactly = 1) { repository.saverUsers(savedUsers) }
    }

    @Test
    fun `when local db isEmpty and api is called and isEmpty`() = runBlocking {

        coEvery { repository.getAllUsersLocal() } returns emptyList()
        coEvery { repository.getUsersFromApi() } returns emptyList()

        coEvery { repository.saverUsers(emptyList()) } returns Unit

        val result = useCase()
        coVerify (exactly = 1) { repository.getUsersFromApi() }
        assertTrue(result.isEmpty())
    }

    @Test
    fun `when local db isNotEmpty and return data successfully`() = runBlocking {

        val localUsers = listOf(
            UserEntity(
                userId = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            ),
            UserEntity(
                userId = 2,
                name = "Jane",
                email = "email.Jane@fakemail.com",
                phone = "25555502"
            )
        )
        coEvery { repository.getAllUsersLocal() } returns localUsers

        val result = useCase()
        coVerify (exactly = 0) { repository.getUsersFromApi() }
        coVerify (exactly = 0) { repository.saverUsers(mockk()) }
        assertEquals(result, localUsers.map { it.toBind() })
    }



    @Test
    fun `when db returns userBy name`() = runBlocking {
        val nameUser = "Jn"
        val localUsers = listOf(
            UserEntity(
                userId = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            ),
            UserEntity(
                userId = 2,
                name = "Jane",
                email = "email.Jane@fakemail.com",
                phone = "25555502"
            )

        )
        coEvery { repository.searchUserByName(nameUser) } returns localUsers

        val result = useCase.searchUserByName(nameUser)

        assertTrue(result.isNotEmpty())
        assertTrue(result.count() == 2)
    }

}