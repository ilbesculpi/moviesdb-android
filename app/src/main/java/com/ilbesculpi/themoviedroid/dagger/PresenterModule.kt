package com.ilbesculpi.themoviedroid.dagger

import android.content.Context
import com.ilbesculpi.themoviedroid.TheMovieDroidApp
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
    fun provideHomePresenter(context: Context) : Home.Presenter {
        val presenter = HomePresenter();
        (context as TheMovieDroidApp).mApplicationComponent.inject(presenter);
        return presenter;
    }

}