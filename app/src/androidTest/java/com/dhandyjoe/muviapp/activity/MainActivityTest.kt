package com.dhandyjoe.muviapp.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import org.junit.Before

import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dhandyjoe.muviapp.util.EspressoIdlingResource


import com.dhandyjoe.muviapp.R
import com.dhandyjoe.muviapp.adapter.FilmAdapter
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.database.ConstantsTVShow
import org.junit.After
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyDataMovie = ConstantsMovie.getMovieList()
    private val dummyDataTVShow = ConstantsTVShow.getTVShowList()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun swipeUpRecycleViewMovie() {
        onView(withId(R.id.rv_movie))
            .perform(swipeUp())
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<FilmAdapter.MyViewHolder>(0, click()))

        // title
        onView(withId(R.id.tv_titleDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_titleDetail))
            .check(matches(withText(dummyDataMovie[0].title)))

        // genre
        onView(withId(R.id.tv_genreDetails))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_genreDetails))
            .check(matches(withText(dummyDataMovie[0].genre)))

        // poster
        onView(withId(R.id.iv_movieDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.iv_movieDetail))
            .check(matches(withContentDescription("poster_detail")))

        // release date
        onView(withId(R.id.tv_releaseDateDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_releaseDateDetail))
            .check(matches(withText(dummyDataMovie[0].date)))

        // rating bar
        onView(withId(R.id.rv_ratingDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_ratingDetail))
            .check(matches(withContentDescription("ratingbar_detailMovie")))

        // description
        onView(withId(R.id.tv_sinopsisDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsisDetail))
            .check(matches(withText(dummyDataMovie[0].desc)))
    }

    @Test
    fun doSwipeRight() {
        onView(withId(R.id.viewPager))
            .perform(swipeLeft())
    }

    @Test
    fun swipeUpRecycleViewTVShow() {
        onView(withId(R.id.viewPager))
            .perform(swipeLeft())
        onView(withId(R.id.rv_tvShow))
            .perform(swipeUp())
    }

    @Test
    fun loadDetailTVShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_tvShow))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rv_tvShow))
            .perform(RecyclerViewActions.actionOnItemAtPosition<FilmAdapter.MyViewHolder>(0, click()))

        // title
        onView(withId(R.id.tv_titleDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_titleDetail))
            .check(matches(withText(dummyDataTVShow[0].title)))

        // genre
        onView(withId(R.id.tv_genreDetails))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_genreDetails))
            .check(matches(withText(dummyDataTVShow[0].genre)))

        // poster
        onView(withId(R.id.iv_movieDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.iv_movieDetail))
            .check(matches(withContentDescription("poster_detail")))

        // release date
        onView(withId(R.id.tv_releaseDateDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_releaseDateDetail))
            .check(matches(withText(dummyDataTVShow[0].date)))

        // rating bar
        onView(withId(R.id.rv_ratingDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_ratingDetail))
            .check(matches(withContentDescription("ratingbar_detailMovie")))

        // description
        onView(withId(R.id.tv_sinopsisDetail))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsisDetail))
            .check(matches(withText(dummyDataTVShow[0].desc)))
    }

    @Test
    fun addMovieFavorite() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.iv_favoriteDetail)).perform(click())

        Espresso.pressBack()

        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.iv_favoriteDetail)).perform(click())

        onView(withId(R.id.tv_titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genreDetails)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_releaseDateDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_ratingDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_movieDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_sinopsisDetail)).check(matches(isDisplayed()))
    }

    @Test
    fun openFavoritePage() {
        onView(withId(R.id.iv_favorite)).perform(click())
    }
}