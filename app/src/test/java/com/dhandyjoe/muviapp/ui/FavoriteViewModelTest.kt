package com.dhandyjoe.muviapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.model.ModelFilm
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<PagedList<ModelFilm>>

    @Mock
    private lateinit var filmRepository: FilmRepository


    @Mock
    private lateinit var pagedList: PagedList<ModelFilm>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(filmRepository)
    }

    @Test
    fun getMovie() {
        val dummyCourses = pagedList
        `when`(dummyCourses.size).thenReturn(5)
        val courses = MutableLiveData<PagedList<ModelFilm>>()
        courses.value = dummyCourses

        `when`(filmRepository.getFavoriteMovie()).thenReturn(courses)
        val courseEntities = viewModel.getMovie().value
        verify<FilmRepository>(filmRepository).getFavoriteMovie()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }

    @Test
    fun getTVShow() {
        val dummyCourses = pagedList
        `when`(dummyCourses.size).thenReturn(5)
        val courses = MutableLiveData<PagedList<ModelFilm>>()
        courses.value = dummyCourses

        `when`(filmRepository.getFavoriteTvShow()).thenReturn(courses)
        val courseEntities = viewModel.getTVShow().value
        verify<FilmRepository>(filmRepository).getFavoriteTvShow()
        assertNotNull(courseEntities)
        assertEquals(5, courseEntities?.size)

        viewModel.getTVShow().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}