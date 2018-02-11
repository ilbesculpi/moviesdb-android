package com.ilbesculpi.themoviedroid.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Section
import javax.inject.Inject


/**
 * Home screen.
 * It displays the list of categories (Popular, Top Rated, Upcoming) for movies or tv shows.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var presenter: Home.Presenter;
    
    lateinit var section: Section;
    
    companion object {
        
        fun newInstance(section: Section) : HomeFragment {
            val fragment = HomeFragment();
            val args = Bundle();
            args.putSerializable("section", section);
            fragment.arguments = args;
            return fragment;
        }
        
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        presenter = configurePresenter();
        if( arguments != null ) {
            section = arguments.getSerializable("section") as Section;
        }
    }
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.home_layout, container, false)
    }
    
    override fun onStart() {
        super.onStart();
        presenter.onStart();
    }
    
    override fun onStop() {
        presenter.onStop();
        super.onStop();
    }
    
    override fun onResume() {
        super.onResume();
        presenter.onResume();
    }
    
    override fun onPause() {
        presenter.onPause();
        super.onPause();
    }

}
