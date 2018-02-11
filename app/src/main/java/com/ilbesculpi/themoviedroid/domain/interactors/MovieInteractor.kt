package com.ilbesculpi.themoviedroid.domain.interactors

import android.database.Observable
import com.ilbesculpi.themoviedroid.domain.models.Movie

interface MovieInteractor {

    fun fetchPopularMovies() : Observable<List<Movie>>;
    fun fetchTopRatedMovies() : Observable<List<Movie>>;
    fun fetchUpcomingMovies() : Observable<List<Movie>>;

}