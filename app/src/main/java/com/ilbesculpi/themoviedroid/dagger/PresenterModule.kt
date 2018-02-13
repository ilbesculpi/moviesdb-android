package com.ilbesculpi.themoviedroid.dagger

import com.ilbesculpi.themoviedroid.ui.home.Home
import com.ilbesculpi.themoviedroid.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Presenter's creation and configuration.
 */
@Module
class PresenterModule {

    @Provides
    fun provideHomePresenter() : Home.Presenter {
        val presenter = HomePresenter();
        return presenter;
    }

}
