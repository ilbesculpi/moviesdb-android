package com.ilbesculpi.themoviedroid.domain.interactors

import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.domain.models.Section
import io.reactivex.Observable

interface MovieInteractor {
    
    fun fetchCategoriesForSection(section: Section) : Observable<List<Category>>;

    fun fetchPopularMovies(page: Int) : Observable<List<Movie>>
    fun fetchTopRatedMovies(page: Int) : Observable<List<Movie>>
    fun fetchUpcomingMovies(page: Int) : Observable<List<Movie>>

}