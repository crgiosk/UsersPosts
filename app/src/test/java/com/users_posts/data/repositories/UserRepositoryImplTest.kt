package com.users_posts.data.repositories

import com.users_posts.data.local.daos.UserDAO
import com.users_posts.data.local.entities.UserEntity
import com.users_posts.data.network.models.post.PostApiResponse
import com.users_posts.data.network.models.user.UserApiResponse
import com.users_posts.data.network.services.PostApiService
import com.users_posts.data.network.services.UserAPIService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class UserRepositoryImplTest {

    @RelaxedMockK
    lateinit var userApiService: UserAPIService

    @RelaxedMockK
    lateinit var userDAO: UserDAO

    lateinit var repository: UserRepositoryImpl

    @Before
    fun onStart() {
        MockKAnnotations.init(this)
        repository = UserRepositoryImpl(
            userApiService,
            userDAO
        )
    }

    @Test
    fun `Validate getUsersFromApi not empty data`() = runTest {
        val response = listOf(
            UserApiResponse(
                id = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            )
        )
        coEvery {
            userApiService.getAllUsers()
        } returns response

        val result = repository.getUsersFromApi()

        assert(result.isNotEmpty())

    }

    @Test
    fun `Validate getUsersFromApi empty data`() = runTest {
        coEvery {
            userApiService.getAllUsers()
        } returns emptyList()

        val result = repository.getUsersFromApi()

        assert(result.isEmpty())

    }

    @Test
    fun `Validate getAllUsersLocal not empty data`() = runTest {
        val response = listOf(
            UserEntity(
                userId = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            )
        )
        coEvery {
            userDAO.getAllUsers()
        } returns response

        val result = repository.getAllUsersLocal()

        assert(result.isNotEmpty())

    }

    @Test
    fun `Validate getAllUsersLocal empty data`() = runTest {
        coEvery {
            userDAO.getAllUsers()
        } returns emptyList()

        val result = repository.getAllUsersLocal()

        assert(result.isEmpty())

    }

    @Test
    fun `Validate saverUsers with empty list`() = runTest {

        repository.saverUsers(emptyList())
        coVerify { userDAO.insertUsers(emptyList()) }

    }

    @Test
    fun `Validate saverUsers with not empty list`() = runTest {
        val list = listOf(
            UserEntity(
                userId = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            )
        )
        repository.saverUsers(list)

        coVerify { userDAO.insertUsers(list) }

    }



    @Test
    fun `Validate searchUserByName not empty data`() = runTest {
        val response = listOf(
            UserEntity(
                userId = 1,
                name = "John",
                email = "email.John@fakemail.com",
                phone = "25555501"
            )
        )
        coEvery {
            userDAO.searchUserByName(any<String>())
        } returns response

        val result = repository.searchUserByName("Ab")

        assert(result.isNotEmpty())

    }

    @Test
    fun `Validate searchUserByName empty data`() = runTest {
        coEvery {
            userDAO.searchUserByName(any<String>())
        } returns emptyList()

        val result = repository.searchUserByName("Ab")

        assert(result.isEmpty())

    }

}