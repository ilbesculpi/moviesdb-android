package com.ilbesculpi.themoviedroid.ui.movies.list

import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import javax.inject.Inject

class MovieListPresenter : MovieList.Presenter {
    
    @Inject
    override lateinit var view: MovieList.View;
    
    @Inject
    lateinit var interactor: MovieInteractor;
    
    override fun onViewReady() {
        interactor.fetchPopularMovies(1)
                .subscribe({ movies ->
                    view.displayMovies(movies);
                }, { error ->
                    view.showUserError(error.localizedMessage);
                });
    }

}