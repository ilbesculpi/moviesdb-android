package com.ilbesculpi.themoviedroid.dagger

import com.ilbesculpi.themoviedroid.persistence.interactors.MovieInteractorImpl
import com.ilbesculpi.themoviedroid.ui.home.HomeFragment
import com.ilbesculpi.themoviedroid.ui.home.HomePresenter
import com.ilbesculpi.themoviedroid.ui.movies.list.MovieListFragment
import com.ilbesculpi.themoviedroid.ui.movies.list.MovieListPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Inject application components.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, PresenterModule::class, InteractorModule::class))
interface AppComponent {
    
    // Fragments
    fun inject(target: HomeFragment);
    fun inject(target: MovieListFragment);
    
    // Presenter
    fun inject(target: HomePresenter);
    fun inject(target: MovieListPresenter);
    
    // Interactor
    fun inject(target: MovieInteractorImpl);

}
