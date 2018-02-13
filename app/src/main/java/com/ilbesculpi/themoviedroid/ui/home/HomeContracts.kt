package com.ilbesculpi.themoviedroid.ui.home

import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.ui.common.Base
import io.reactivex.Observable

interface Home {
    
    interface View : Base.View {
        
        var presenter: Home.Presenter;
    
        fun displayCategories(categories: List<Category>);
        
    }
    
    interface Presenter : Base.Presenter {
        
        var view: Home.View;
        
        var section: Section;
    
        fun fetchCategories();
        
    }
    
}