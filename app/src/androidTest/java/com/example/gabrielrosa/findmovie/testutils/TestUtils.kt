package com.example.gabrielrosa.findmovie.testutils

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.KeyEvent
import java.lang.Thread.sleep

/**
 * Created by gabrielrosa on 27/02/18.
 */
class TestUtils {

    fun waitEspresso(milles: Long) {
        try {
            sleep(milles)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun checkIfIdIsDisplayed(id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))
    }

    fun findAndClick(id: Int) {
        onView(withId(id)).perform(click())
    }

    fun clickOnRecyclerViewItem(recyclerId: Int, position: Int, viewInsideRecycler: Int) {
        onView(RecyclerViewMatcher.withRecyclerView(recyclerId).atPositionOnView(position, viewInsideRecycler)).perform(ViewActions.click())
    }

    fun typeOnSearchView(text: String) {
        onView(withId(android.support.design.R.id.search_src_text)).perform(typeText(text), ViewActions.pressKey(KeyEvent.KEYCODE_ENTER));
    }
}