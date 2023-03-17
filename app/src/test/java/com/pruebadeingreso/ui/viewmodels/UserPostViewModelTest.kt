package com.pruebadeingreso.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pruebadeingreso.data.usecase.PostUseCase
import com.pruebadeingreso.data.usecase.UserUseCase
import com.pruebadeingreso.ui.binds.PostUserBind
import com.pruebadeingreso.ui.binds.UserBind
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Assert.assertNull
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserPostViewModelTest {

    @RelaxedMockK
    private lateinit var userUseCase: UserUseCase

    @RelaxedMockK
    private lateinit var postUseCase: PostUseCase

    @RelaxedMockK
    private lateinit var viewModel: UserPostViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        viewModel = UserPostViewModel(userUseCase, postUseCase)

        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `validate default values`() {
        assertNull(viewModel.usersList.value)
        assertNull(viewModel.postByUserList.value)
        assertNull(viewModel.userSelected)
        assertTrue(viewModel.showLoading.value == false)
        assertTrue(viewModel.isEmptyList.value == false)
    }

    @Test
    fun `validate validate setter methods`() {
        assertTrue(viewModel.showLoading.value == false)
        viewModel.showLoadingSet(true)
        assertTrue(viewModel.showLoading.value == true)

        assertTrue(viewModel.isEmptyList.value == false)
        viewModel.isEmptyListSet(true)
        assertTrue(viewModel.isEmptyList.value == true)

    }

    @Test
    fun `validate when getUsers method is called`() {
        val users = listOf(
            UserBind(
                idUser = 1,
                name = "John",
                email = "email.John@fakemail.com",
                numberPhone = "25555501"
            ),
            UserBind(
                idUser = 2,
                name = "Jane",
                email = "email.Jane@fakemail.com",
                numberPhone = "25555502"
            )
        )
        assertTrue(viewModel.showLoading.value == false)
        coEvery { userUseCase() } returns users

        viewModel.getUsers()

        assertNotNull(viewModel.usersList.value)
        assertEquals(viewModel.usersList.value, users)
        assertTrue(viewModel.showLoading.value == false)

    }

    @Test
    fun `validate when getPostByUser method is called`() {
        val idUser = 1
        val myList = mutableListOf(
            PostUserBind(
                idUser,
                "AnyTitle",
                "orem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel dictum orci. Aliquam ut nunc eget eros accumsan varius vel et arcu. In tempor odio at dui auctor, eu fringilla ligula accumsan."
            )
        )
        assertTrue(viewModel.showLoading.value == false)
        coEvery { postUseCase.getPostByUser(idUser) } returns myList

        viewModel.userSelected = UserBind(idUser, "name", "123", "fak.email@email")
        viewModel.getPostByUser()

        assertNotNull(viewModel.postByUserList.value)
        assertEquals(viewModel.postByUserList.value, myList)
        assertTrue(viewModel.showLoading.value == false)

    }

    @Test
    fun `validate when searchUserByName method is called`() {

        val nameUser = "Jn"
        val localUsers = listOf(
            UserBind(
                idUser = 1,
                name = "John",
                email = "email.John@fakemail.com",
                numberPhone = "25555501"
            ),
            UserBind(
                idUser = 2,
                name = "Jane",
                email = "email.Jane@fakemail.com",
                numberPhone = "25555502"
            )

        )
        coEvery { userUseCase.searchUserByName(nameUser) } returns localUsers
        assertTrue(viewModel.showLoading.value == false)

        var wasSuccess = false

        viewModel.searchUserByName(nameUser) {
            assertTrue(it.isNotEmpty())
            wasSuccess = true
        }

        assertTrue(wasSuccess)

    }



    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

}