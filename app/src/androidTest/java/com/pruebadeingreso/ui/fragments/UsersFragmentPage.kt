package com.pruebadeingreso.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import com.pruebadeingreso.Page
import com.pruebadeingreso.R
import com.pruebadeingreso.ui.adapters.UserAdapter
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

class UsersFragmentPage : Page() {

    fun checkIsVisible(): UsersFragmentPage {

        onView(withId(R.id.fragment_users_parent_layout))
            .check(matches(isDisplayed()))
        return this
    }

    fun checkIfListUserIsEmpty(): UsersFragmentPage {

        onView(withId(R.id.usersRecyclerView))
            .check(
                matches(not(hasChildCount(0)))
            )
        return this
    }

    fun checkIfEditTextIsEmpty(): UsersFragmentPage {
        onView(withId(R.id.findUserEditText))
            .check(matches(ViewMatchers.withText("")))
        return this

    }

    fun onClickUser() : UsersFragmentPage {
        onView(withId(R.id.usersRecyclerView))
            .perform(
                actionOnItemAtPosition<UserAdapter.ViewHolder>(1, click())
            )

/*        onView(withId(R.id.viewPostButton))
            .perform(click())*/

        return this

    }
}