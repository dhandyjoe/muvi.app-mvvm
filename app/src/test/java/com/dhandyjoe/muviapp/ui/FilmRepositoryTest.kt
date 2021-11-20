package com.dhandyjoe.muviapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dhandyjoe.muviapp.database.ConstantsMovie
import com.dhandyjoe.muviapp.model.ModelFilm
import com.dhandyjoe.muviapp.util.LiveDataTestUtil
import junit.framework.TestCase
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

    private lateinit var viewModelFavorite: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var pagedList: PagedList<ModelFilm>

    @Mock
    private lateinit var observer: Observer<PagedList<ModelFilm>>

    @Before
    fun setUp() {
        viewModel = MainViewModel(filmRepository)
        viewModelFavorite = FavoriteViewModel(filmRepository)
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

    @Test
    fun getFavoriteMovie() {
        val dummyCourses = pagedList
        `when`(dummyCourses.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<ModelFilm>>()
        movie.value = dummyCourses

        `when`(filmRepository.getFavoriteMovie()).thenReturn(movie)
        val courseEntities = viewModelFavorite.getMovie().value
        com.nhaarman.mockitokotlin2.verify<FilmRepository>(filmRepository).getFavoriteMovie()
        assertNotNull(courseEntities)
        TestCase.assertEquals(5, courseEntities?.size)

        viewModelFavorite.getMovie().observeForever(observer)
        com.nhaarman.mockitokotlin2.verify(observer).onChanged(dummyCourses)
    }

    @Test
    fun getFavoriteTV() {
        val dummyCourses = pagedList
        `when`(dummyCourses.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<ModelFilm>>()
        movie.value = dummyCourses

        `when`(filmRepository.getFavoriteTvShow()).thenReturn(movie)
        val courseEntities = viewModelFavorite.getTVShow().value
        com.nhaarman.mockitokotlin2.verify<FilmRepository>(filmRepository).getFavoriteTvShow()
        assertNotNull(courseEntities)
        TestCase.assertEquals(5, courseEntities?.size)

        viewModelFavorite.getTVShow().observeForever(observer)
        com.nhaarman.mockitokotlin2.verify(observer).onChanged(dummyCourses)
    }
}