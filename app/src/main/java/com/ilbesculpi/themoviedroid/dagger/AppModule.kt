package com.ilbesculpi.themoviedroid.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provide app-wide dependencies.
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext() : Context {
        return application;
    }

}
