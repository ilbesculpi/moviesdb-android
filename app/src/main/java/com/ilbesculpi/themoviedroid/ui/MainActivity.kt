package com.ilbesculpi.themoviedroid.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.ui.common.HostFragment
import com.ilbesculpi.themoviedroid.ui.home.HomeFragment
import com.ilbesculpi.themoviedroid.ui.movies.list.MovieListFragment
import com.ilbesculpi.themoviedroid.ui.shows.list.TvShowListFragment
import kotlinx.android.synthetic.main.main_layout.*

/**
 * Represents the main layout of the application.
 */
class MainActivity : AppCompatActivity(), MainContracts.View {
    

    private var pagerAdapter: SectionsPagerAdapter? = null;
    
    lateinit private var viewPager: ViewPager;
    
    private var fragmentTabs: MutableList<HostFragment>;
    
    init {
        fragmentTabs = mutableListOf();
        val moviesFragment = HomeFragment.newInstance(Section.MOVIES);
        fragmentTabs.add(HostFragment.newInstance(moviesFragment));
        val showsFragment = HomeFragment.newInstance(Section.SHOWS)
        fragmentTabs.add(HostFragment.newInstance(showsFragment));
    }
    
    val hostFragment: HostFragment?
        get() {
            return pagerAdapter?.getItem(viewPager.currentItem) as HostFragment;
        }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        
        setSupportActionBar(toolbar);
        
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        pagerAdapter = SectionsPagerAdapter(supportFragmentManager);
        viewPager = findViewById(R.id.view_pager);
        
        // Set up the ViewPager with the sections adapter.
        viewPager.adapter = pagerAdapter;
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        
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
     * Handle back pressed.
     * If there are fragments in the current stack, navigate to previous fragment.
     * Otherwise, exit the app.
     */
    override fun onBackPressed() {
        if( hostFragment?.getChildFragmentManager()?.backStackEntryCount!! > 0 ) {
            // handle back action (navigate to previous fragment)
            hostFragment?.getChildFragmentManager()?.popBackStack();
        }
        else {
            // default behavior (exit app)
            super.onBackPressed();
        }
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
            return fragmentTabs[position];
        }
        
    }
    
    override fun navigateToCategoryScreen(section: Section, category: Category) {
        when( section ) {
            Section.MOVIES -> {
                val fragment: MovieListFragment = MovieListFragment.newInstance(category);
                hostFragment?.replaceFragment(fragment, true);
            }
            Section.SHOWS -> {
                val fragment: TvShowListFragment = TvShowListFragment.newInstance(category);
                hostFragment?.replaceFragment(fragment, true);
            }
        }
    }
    
    override fun navigateToFragment(fragment: Fragment, section: Section, addToBackstack: Boolean) {
        hostFragment?.replaceFragment(fragment, addToBackstack);
    }
    
}
