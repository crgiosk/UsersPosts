package com.users_posts.fragmentpages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.users_posts.helpers.Page
import com.users_posts.R
import org.hamcrest.Matchers.not

class UsersPostFragmentPage : Page() {

    fun createUser(): UsersPostFragmentPage {

        onView(withId(R.id.nameUserLayout))
            .perform(replaceText("Sonny Moore"))

        onView(withId(R.id.phoneLayout))
            .perform(replaceText("255 255 00"))

        onView(withId(R.id.emailLayout))
            .perform(replaceText("let.me.here@fake.com"))

        return this
    }

    fun checkIfListPostIsEmpty(): UsersPostFragmentPage {

        onView(withId(R.id.userPostRecyclerView))
            .check(
                matches(not(ViewMatchers.hasChildCount(0)))
            )
        return this
    }

    fun checkIsVisible(): UsersPostFragmentPage {

        onView(withId(R.id.fragment_users_posts_parent_layout))
            .check(matches(ViewMatchers.isDisplayed()))
        return this
    }


}