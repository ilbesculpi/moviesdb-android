package com.ilbesculpi.themoviedroid.dagger

import com.ilbesculpi.themoviedroid.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

/**
 *
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, PresenterModule::class))
interface AppComponent {
    
    // Fragments
    fun inject(target: HomeFragment);

}
