package com.dhandyjoe.muviapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.util.LiveDataTestUtil
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilmRepositoryTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = MainViewModel(filmRepository)
    }

    private val dummyMovie = ConstantsMovie.getMovieList()
    private val dummyDetailMovie = ConstantsMovie.getMovieList()[0]

    private val local = mock(LocalDataSource::class.java)
    private val fakeFilmRepository = FakeFilmRepository(local)

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as LocalDataSource.LoadMovieCallback)
                .onAllMovieReceived(dummyMovie)
            null
        }.`when`(local).getListMovieDetail(org.mockito.kotlin.any())

        val courseEntities = LiveDataTestUtil.getValue(fakeFilmRepository.getMovieDetail())
        verify(local).getListMovieDetail(org.mockito.kotlin.any())
        assertEquals(dummyMovie.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getTVShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as LocalDataSource.LoadTVCallback)
                .onAllTVReceived(dummyMovie)
            null
        }.`when`(local).getListTvShowDetail(org.mockito.kotlin.any())

        val courseEntities = LiveDataTestUtil.getValue(fakeFilmRepository.getTvShowDetail())
        verify(local).getListTvShowDetail(org.mockito.kotlin.any())
        assertEquals(dummyMovie.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getDetailFilm() {
        doAnswer { invocation ->
            (invocation.arguments[0] as LocalDataSource.LoadDetailCallback)
                .onAllDetailReceived(dummyDetailMovie)
            null
        }.`when`(local).getFilmDetail(org.mockito.kotlin.any())

        val courseEntities = LiveDataTestUtil.getValue(fakeFilmRepository.getDetailFilm())
        verify(local).getFilmDetail(org.mockito.kotlin.any())
        assertEquals(dummyDetailMovie, courseEntities)
    }
}