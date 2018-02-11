package com.ilbesculpi.themoviedroid.ui.movies.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilbesculpi.themoviedroid.R

/**
 * Movie List Screen.
 */
class MovieListFragment : Fragment() {
    
    companion object {
        fun newInstance(): MovieListFragment {
            val fragment = MovieListFragment();
            val args = Bundle();
            fragment.arguments = args;
            return fragment;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if(arguments != null) {
        
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.movie_list_layout, container, false);
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context);
    }

    override fun onDetach() {
        super.onDetach();
    }
    
}
