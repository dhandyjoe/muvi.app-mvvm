package com.dhandyjoe.muviapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.model.ModelFilm
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {

    private lateinit var viewModel: DetailFilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<ModelFilm>

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(filmRepository)
        viewModel.getDetail()
    }

    @Test
    fun getDetailFilm() {
        val dummyCourses = ConstantsMovie.getMovieList()[0]
        val courses = MutableLiveData<ModelFilm>()
        courses.value = dummyCourses

        `when`(filmRepository.getDetailFilm()).thenReturn(courses)
        val courseEntities = viewModel.getDetail()
        assertNotNull(courseEntities)
        assertEquals(courses, courseEntities)

        viewModel.getDetail().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyCourses)
    }
}