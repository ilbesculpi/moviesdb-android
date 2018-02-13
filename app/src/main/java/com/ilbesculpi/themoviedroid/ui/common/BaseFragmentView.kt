package com.ilbesculpi.themoviedroid.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ilbesculpi.themoviedroid.TheMovieDroidApp
import com.ilbesculpi.themoviedroid.dagger.AppComponent

abstract class BaseFragmentView: Fragment(), Base.View {
    
    val appContext: TheMovieDroidApp
        get() { return context.applicationContext as TheMovieDroidApp; }
    
    val appComponent: AppComponent
        get() { return appContext.mApplicationComponent; }
    
    abstract protected fun configureComponents();
    
    override fun startLoadingView() {
    
    }
    
    override fun stopLoadingView() {
    
    }

}