package com.ilbesculpi.themoviedroid.ui.movies.list

import com.ilbesculpi.themoviedroid.domain.models.Movie


interface MovieList {
    
    interface View {
    
        fun showUserError(message: String);
        fun displayMovies(movies: List<Movie>);
        
    }
    
    interface Presenter {
        
        var view: View;
    
        fun onViewReady();
        
    }
    
}