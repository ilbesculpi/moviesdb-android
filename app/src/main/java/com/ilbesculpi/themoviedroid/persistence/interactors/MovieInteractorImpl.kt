package com.ilbesculpi.themoviedroid.persistence.interactors

import io.reactivex.Observable
import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.persistence.network.MovieListResponse
import com.ilbesculpi.themoviedroid.persistence.network.RemoteStore
import javax.inject.Inject


class MovieInteractorImpl : MovieInteractor {
    
    @Inject
    lateinit var remoteStore: RemoteStore;
    
    override fun fetchCategoriesForSection(section: Section): Observable<List<Category>> {
        when( section ) {
            Section.MOVIES -> {
                val categories = arrayListOf<Category>(Category.POPULAR, Category.TOP_RATED, Category.UPCOMING);
                return Observable.just(categories);
            }
            Section.SHOWS -> {
                val categories = arrayListOf<Category>(Category.POPULAR, Category.TOP_RATED);
                return Observable.just(categories);
            }
        }
    }
    
    override fun fetchMovies(category: Category, page: Int): Observable<MovieListResponse> {
        return when( category ) {
            Category.POPULAR -> fetchPopularMovies(page);
            Category.TOP_RATED -> fetchTopRatedMovies(page);
            Category.UPCOMING -> fetchUpcomingMovies(page);
        }
    }
    
    override fun fetchPopularMovies(page: Int): Observable<MovieListResponse> {
        return remoteStore.popularMovies(page);
    }
    
    override fun fetchTopRatedMovies(page: Int): Observable<MovieListResponse> {
        return remoteStore.topRatedMovies(page);
    }
    
    override fun fetchUpcomingMovies(page: Int): Observable<MovieListResponse> {
        return remoteStore.upcomingMovies(page);
    }
    
}