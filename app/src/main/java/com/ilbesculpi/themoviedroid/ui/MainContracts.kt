package com.ilbesculpi.themoviedroid.ui

import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section

interface MainContracts {
    
    interface View {
        
        fun navigateToCategoryScreen(section: Section, category: Category);
        
    }
    
}