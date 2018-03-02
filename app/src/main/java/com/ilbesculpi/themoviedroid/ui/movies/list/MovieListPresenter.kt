package com.ilbesculpi.themoviedroid.ui.movies.list

import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.ui.common.BasePresenter
import io.reactivex.Observable
import javax.inject.Inject

class MovieListPresenter : BasePresenter(), MovieList.Presenter {
    
    override var view: MovieList.View? = null;
    
    @Inject
    lateinit var interactor: MovieInteractor;
    
    override lateinit var category: Category;
    
    override fun onStart() {
        
        // display screen title
        val title: String = when( category ) {
            Category.POPULAR -> context.getString(R.string.popular)
            Category.TOP_RATED -> context.getString(R.string.top_rated)
            Category.UPCOMING -> context.getString(R.string.upcoming)
        };
        view?.displayTitle(title);
    
        // fetch movies
        interactor.fetchMovies(category, 1)
                .subscribe({ response ->
                    val movies = response.results!!.asList();
                    view?.displayMovies(movies);
                }, { error ->
                    view?.showUserError(error.localizedMessage);
                });
    }
    
    override fun onDestroy() {
        view = null;
        super.onDestroy();
    }

}