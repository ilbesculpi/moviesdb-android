package com.ilbesculpi.themoviedroid.ui.shows.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category

/**
 * TV Shows List Screen.
 */
class TvShowListFragment : Fragment() {
    
    lateinit var category: Category;
    
    companion object {
        fun newInstance(category: Category): TvShowListFragment {
            val fragment = TvShowListFragment();
            val args = Bundle();
            args.putSerializable("category", category);
            fragment.arguments = args;
            return fragment;
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if(arguments != null) {
            category = arguments.getSerializable("category") as Category;
        }
    }
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.tv_show_list_layout, container, false);
    }
    
    override fun onAttach(context: Context?) {
        super.onAttach(context);
    }
    
    override fun onDetach() {
        super.onDetach();
    }
    
}