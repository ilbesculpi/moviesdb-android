package com.ilbesculpi.themoviedroid.ui.common

interface Base {
    
    interface View {
        
        fun startLoadingView();
        fun stopLoadingView();
        
    }
    
    interface Presenter {
    
        fun onStart();
        fun onStop();
        fun onResume();
        fun onPause();
        
    }
    
}