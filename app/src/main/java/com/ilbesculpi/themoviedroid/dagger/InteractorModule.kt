package com.ilbesculpi.themoviedroid.dagger

import android.content.Context
import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import com.ilbesculpi.themoviedroid.persistence.interactors.MovieInteractorImpl
import com.ilbesculpi.themoviedroid.persistence.network.RemoteStore
import dagger.Module
import dagger.Provides

/**
 * Interactor's creation and configuration.
 */
@Module
class InteractorModule {

    @Provides
    fun provideMovieInteractor(context: Context) : MovieInteractor {
        val interactor = MovieInteractorImpl();
        interactor.remoteStore = provideRemoteStore(context);
        return interactor;
    }
    
    @Provides
    fun provideRemoteStore(context: Context) : RemoteStore {
        val store = RemoteStore();
        return store;
    }

}