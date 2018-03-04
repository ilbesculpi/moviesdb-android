package com.ilbesculpi.themoviedroid.ui.movies.detail

import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.ui.common.Base

interface MovieDetail {

    interface View: Base.View {
    
        var presenter: MovieDetail.Presenter;
        
        fun displayMovie(movie: Movie);
        
    }
    
    interface Presenter: Base.Presenter {
        
        var view: MovieDetail.View?
        var movie: Movie;
        
    }

}