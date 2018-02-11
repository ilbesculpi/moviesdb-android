package com.ilbesculpi.themoviedroid

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.ui.movies.list.MovieListFragment
import com.ilbesculpi.themoviedroid.ui.shows.list.TvShowListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when( item.itemId ) {
            R.id.menu_movies -> {
                displaySection(Section.MOVIES);
                return@OnNavigationItemSelectedListener true;
            }
            R.id.menu_tv_shows -> {
                displaySection(Section.SHOWS);
                return@OnNavigationItemSelectedListener true;
            }
        }
        false
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        displaySection(Section.MOVIES);
    }
    
    fun displaySection(section: Section) {
    
        when( section ) {
            Section.MOVIES -> {
                val fragment: MovieListFragment = MovieListFragment.newInstance();
                switchToFragment(fragment);
            }
            Section.SHOWS -> {
                val fragment: TvShowListFragment = TvShowListFragment.newInstance();
                switchToFragment(fragment);
            }
        }
    
    }
    
    fun switchToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
    
}
