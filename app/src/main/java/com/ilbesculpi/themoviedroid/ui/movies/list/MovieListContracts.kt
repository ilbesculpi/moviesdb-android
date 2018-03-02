package com.ilbesculpi.themoviedroid.ui.movies.list

import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.ui.common.Base


interface MovieList {
    
    interface View : Base.View {
    
        var presenter: MovieList.Presenter;
        
        fun showUserError(message: String);
        fun displayTitle(title: String);
        fun displayMovies(movies: List<Movie>);
        
    }
    
    interface Presenter : Base.Presenter {
        
        var view: MovieList.View?;
        var category: Category;
        
    }
    
}