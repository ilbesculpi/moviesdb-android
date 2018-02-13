package com.ilbesculpi.themoviedroid.ui.home

import com.ilbesculpi.themoviedroid.domain.interactors.MovieInteractor
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.ui.common.BasePresenter
import javax.inject.Inject

class HomePresenter : BasePresenter(), Home.Presenter {
    
    lateinit override var view: Home.View;
    
    lateinit override var section: Section;
    
    @Inject
    lateinit var interactor: MovieInteractor;
    
    override fun onStart() {
        super.onStart();
        fetchCategories();
    }
    
    override fun fetchCategories() {
        interactor.fetchCategoriesForSection(section)
                .subscribe { categories ->
                    view.displayCategories(categories);
                }
        
    }

}