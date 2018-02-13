package com.ilbesculpi.themoviedroid.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.ui.home.HomeFragment
import com.ilbesculpi.themoviedroid.ui.movies.list.MovieListFragment
import com.ilbesculpi.themoviedroid.ui.shows.list.TvShowListFragment
import kotlinx.android.synthetic.main.main_layout.*

/**
 * Represents the main layout of the application.
 */
class MainActivity : AppCompatActivity(), MainContracts.View {
    
    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        
        setSupportActionBar(toolbar);
        
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager);
        
        // Set up the ViewPager with the sections adapter.
        fragment_container.adapter = mSectionsPagerAdapter;
        fragment_container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(fragment_container));
        
    }
    
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        
        when( item.itemId ) {
            R.id.action_settings -> {
                // TODO: handle settings click
                return true;
            }
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    
    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    
        override fun getCount(): Int {
            return 2;
        }
        
        override fun getItem(position: Int): Fragment {
            
            assert(position < 0 || position > 1);
            
            if( position == 0 ) {
                val fragment = HomeFragment.newInstance(Section.MOVIES);
                return fragment;
            }
            
            if( position == 1 ) {
                val fragment = HomeFragment.newInstance(Section.SHOWS);
                return fragment;
            }
            
            return Fragment();
        }
        
    }
    
    override fun navigateToCategoryScreen(section: Section, category: Category) {
        when( section ) {
            Section.MOVIES -> {
                val fragment: MovieListFragment = MovieListFragment.newInstance(category);
                
            }
            Section.SHOWS -> {
            
            }
        }
    }
    
}
