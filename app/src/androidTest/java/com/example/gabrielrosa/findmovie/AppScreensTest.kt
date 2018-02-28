package com.example.gabrielrosa.findmovie

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.gabrielrosa.findmovie.application.home.HomeActivity
import com.example.gabrielrosa.findmovie.testutils.RecyclerViewMatcher
import com.example.gabrielrosa.findmovie.testutils.TestUtils
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by gabrielrosa on 27/02/18.
 */
@RunWith(AndroidJUnit4::class)
class AppScreensTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

    @Test
    fun when_do_valid_search() {

        TestUtils().findAndClick(R.id.moviesSearchView)
        TestUtils().typeOnSearchView("Nemo")
        TestUtils().waitEspresso(3000)

        RecyclerViewMatcher.checkIfDisplayedOnRecycleViewItem(R.id.moviesRecyclerView, 0, R.id.detailButton)
    }

    @Test
    fun when_do_invalid_search(){
        TestUtils().findAndClick(R.id.moviesSearchView)
        TestUtils().typeOnSearchView("Nasfasfasfasfasfasfasfemo")
        TestUtils().waitEspresso(3000)

        TestUtils().checkIfIdIsDisplayed(R.id.emptyDataText)
    }

    @Test
    fun when_click_on_movie_detail() {
        TestUtils().findAndClick(R.id.moviesSearchView)
        TestUtils().typeOnSearchView("Nemo")

        TestUtils().clickOnRecyclerViewItem(R.id.moviesRecyclerView, 0, R.id.detailButton)
        TestUtils().waitEspresso(3000)

        TestUtils().checkIfIdIsDisplayed(R.id.movieDetailTitle)
    }
}