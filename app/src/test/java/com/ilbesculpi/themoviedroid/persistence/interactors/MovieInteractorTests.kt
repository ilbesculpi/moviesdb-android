package com.ilbesculpi.themoviedroid.persistence.interactors

import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.Test

class MovieInteractorTests {
    
    lateinit var interactor: MovieInteractorImpl;
    
    @Before
    fun setup() {
        interactor = MovieInteractorImpl();
    }
    
    @After
    fun tearDown() {
    
    }
    
    @Test
    fun testCategoriesForMovies() {
        
        val consumer: TestObserver<List<Category>> = TestObserver();
        
        interactor.fetchCategoriesForSection(Section.MOVIES)
                .subscribe(consumer);
        
        val expected = arrayListOf<Category>(Category.POPULAR, Category.TOP_RATED, Category.UPCOMING);
        consumer.assertComplete();
        consumer.assertNoErrors();
        consumer.assertResult(expected);
    }
    
    @Test
    fun testCategoriesForShows() {
    
        val consumer: TestObserver<List<Category>> = TestObserver();
    
        interactor.fetchCategoriesForSection(Section.SHOWS)
                .subscribe(consumer);
    
        val expected = arrayListOf<Category>(Category.POPULAR, Category.TOP_RATED);
        consumer.assertComplete();
        consumer.assertNoErrors();
        consumer.assertResult(expected);
    }
    
}