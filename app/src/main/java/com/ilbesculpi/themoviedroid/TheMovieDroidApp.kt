package com.ilbesculpi.themoviedroid

import android.app.Application
import com.ilbesculpi.themoviedroid.dagger.AppComponent
import com.ilbesculpi.themoviedroid.dagger.AppModule
import com.ilbesculpi.themoviedroid.dagger.DaggerAppComponent


class TheMovieDroidApp : Application() {
    
    lateinit var mApplicationComponent: AppComponent;
    
    override fun onCreate() {
        super.onCreate();
        mApplicationComponent = initDagger(this);
    }
    
    private fun initDagger(application: TheMovieDroidApp) : AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .build();
    }

}