package com.ilbesculpi.themoviedroid.ui.movies.detail

import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.ui.common.BasePresenter


class MovieDetailPresenter: BasePresenter(), MovieDetail.Presenter {
    
    override var view: MovieDetail.View? = null;
    
    override lateinit var movie: Movie;
    
    override fun onResume() {
        super.onResume();
        view?.displayMovie(movie);
    }
    
}