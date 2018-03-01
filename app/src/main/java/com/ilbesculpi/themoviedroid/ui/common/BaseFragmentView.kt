package com.ilbesculpi.themoviedroid.ui.common

import android.content.Context
import android.support.v4.app.Fragment
import com.ilbesculpi.themoviedroid.TheMovieDroidApp
import com.ilbesculpi.themoviedroid.dagger.AppComponent
import com.ilbesculpi.themoviedroid.ui.MainContracts

abstract class BaseFragmentView: Fragment(), Base.View {
    
    val appContext: TheMovieDroidApp
        get() { return context.applicationContext as TheMovieDroidApp; }
    
    val appComponent: AppComponent
        get() { return appContext.mApplicationComponent; }
    
    lateinit var mHolder: MainContracts.View;
    
    abstract protected fun configureComponents();
    
    override fun startLoadingView() {
    
    }
    
    override fun stopLoadingView() {
    
    }
    
    override fun onAttach(context: Context?) {
        super.onAttach(context);
        mHolder = context as MainContracts.View;
    }

}