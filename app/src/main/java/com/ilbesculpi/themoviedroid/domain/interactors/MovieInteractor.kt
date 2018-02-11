package com.ilbesculpi.themoviedroid.domain.interactors

import com.ilbesculpi.themoviedroid.domain.models.Movie
import io.reactivex.Observable

interface MovieInteractor {

    fun fetchPopularMovies(page: Int) : Observable<List<Movie>>
    fun fetchTopRatedMovies(page: Int) : Observable<List<Movie>>
    fun fetchUpcomingMovies(page: Int) : Observable<List<Movie>>

}