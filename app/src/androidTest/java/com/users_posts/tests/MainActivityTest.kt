package com.users_posts.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.users_posts.pages.MainPage
import com.users_posts.fragmentpages.UsersFragmentPage
import com.users_posts.fragmentpages.UsersPostFragmentPage
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Test
    fun testApiDataShownInRecyclerView() {
        val scenario = MainPage()

        scenario.launch()
            .atPage<UsersFragmentPage>()
            .checkIsVisible()
            .checkIfListUserIsEmpty()
            .checkIfEditTextIsEmpty()
        scenario
            .close()

    }


    @Test
    fun checkDefaultValueEditText() {
        val scenario = MainPage()

        scenario.launch()
            .atPage<UsersFragmentPage>()
            .checkIfEditTextIsEmpty()
        scenario
            .close()

    }


    @Test
    fun checkOnClickUser() {
        val scenario = MainPage()

        scenario.launch()
            .atPage<UsersFragmentPage>()
            .checkIsVisible()
            .onClickUser()
            .atPage<UsersPostFragmentPage>()

        scenario
            .close()

    }
}