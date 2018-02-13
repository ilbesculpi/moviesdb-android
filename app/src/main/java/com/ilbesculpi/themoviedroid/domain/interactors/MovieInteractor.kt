package com.ilbesculpi.themoviedroid.domain.interactors

import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.persistence.network.MovieListResponse
import io.reactivex.Observable

interface MovieInteractor {
    
    fun fetchCategoriesForSection(section: Section) : Observable<List<Category>>;

    fun fetchMovies(category: Category, page: Int) : Observable<MovieListResponse>;
    fun fetchPopularMovies(page: Int) : Observable<MovieListResponse>
    fun fetchTopRatedMovies(page: Int) : Observable<MovieListResponse>
    fun fetchUpcomingMovies(page: Int) : Observable<MovieListResponse>

}