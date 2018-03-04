package com.ilbesculpi.themoviedroid.ui

import android.support.v4.app.Fragment
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section

interface MainContracts {
    
    interface View {
        
        fun navigateToCategoryScreen(section: Section, category: Category);
        fun navigateToFragment(fragment: Fragment, section: Section, addToBackstack: Boolean = true);
        
    }
    
}