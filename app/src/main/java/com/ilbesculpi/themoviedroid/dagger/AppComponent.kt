package com.ilbesculpi.themoviedroid.dagger

import com.ilbesculpi.themoviedroid.persistence.interactors.MovieInteractorImpl
import com.ilbesculpi.themoviedroid.ui.home.HomeFragment
import com.ilbesculpi.themoviedroid.ui.home.HomePresenter
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
    
    // Presenter
    fun inject(target: HomePresenter);
    
    // Interactor
    fun inject(target: MovieInteractorImpl);

}
