package com.dhandyjoe.muviapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.database.ConstantsTVShow
import com.dhandyjoe.muviapp.model.ModelFilm
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<ModelFilm>>

    @Before
    fun setUp() {
        viewModel = MainViewModel(filmRepository)
        viewModel.getDataMovie()
    }

    @Test
    fun getMovie() {
        val dummyCourses = ConstantsMovie.getMovieList()
        val courses = MutableLiveData<ArrayList<ModelFilm>>()
        courses.value = dummyCourses

        `when`(filmRepository.getMovieDetail()).thenReturn(courses)
        val courseEntities = viewModel.getDataMovie().value
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getDataMovie().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }

    @Test
    fun getTVShow() {
        val dummyCourses = ConstantsTVShow.getTVShowList()
        val courses = MutableLiveData<ArrayList<ModelFilm>>()
        courses.value = dummyCourses

        `when`(filmRepository.getTvShowDetail()).thenReturn(courses)
        val courseEntities = viewModel.getDataTVShow().value
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getDataTVShow().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}