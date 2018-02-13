package com.ilbesculpi.themoviedroid.ui.movies.list

import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.ui.common.BasePresenter
import io.reactivex.Observable
import javax.inject.Inject

class MovieListPresenter : BasePresenter(), MovieList.Presenter {
    
    @Inject
    override lateinit var view: MovieList.View;
    
    @Inject
    lateinit var interactor: MovieInteractor;
    
    override lateinit var category: Category;
    
    override fun onStart() {
        interactor.fetchPopularMovies(1)
                .subscribe({ response ->
                    val movies = response.results!!.asList();
                    view.displayMovies(movies);
                }, { error ->
                    view.showUserError(error.localizedMessage);
                });
    }

}