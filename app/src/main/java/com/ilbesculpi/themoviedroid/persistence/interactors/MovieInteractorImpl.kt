package com.ilbesculpi.themoviedroid.persistence.interactors

import io.reactivex.Observable
import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.persistence.network.RemoteStore
import javax.inject.Inject


class MovieInteractorImpl : MovieInteractor {
    
    @Inject
    var remoteStore: RemoteStore? = null;
    
    override fun fetchPopularMovies(page: Int): Observable<List<Movie>> {
        return remoteStore?.popularMovies(page)!!
            .flatMap { results ->
                Observable.just(results.results!!)
            }
            .flatMap { movies ->
                 Observable.just(movies.asList())
            }
    }
    
    override fun fetchTopRatedMovies(page: Int): Observable<List<Movie>> {
        return remoteStore?.topRatedMovies(page)!!
                .flatMap { results ->
                    Observable.just(results.results!!)
                }
                .flatMap { movies ->
                    Observable.just(movies.asList())
                }
    }
    
    override fun fetchUpcomingMovies(page: Int): Observable<List<Movie>> {
        return remoteStore?.upcomingMovies(page)!!
                .flatMap { results ->
                    Observable.just(results.results!!)
                }
                .flatMap { movies ->
                    Observable.just(movies.asList())
                }
    }
    
}