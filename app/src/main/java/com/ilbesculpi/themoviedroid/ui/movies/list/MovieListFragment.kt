package com.ilbesculpi.themoviedroid.ui.movies.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.ui.common.BaseFragmentView
import javax.inject.Inject

/**
 * Movie List Screen.
 */
class MovieListFragment : BaseFragmentView(), MovieList.View {
    
    @Inject
    lateinit var presenter: MovieList.Presenter;
    
    lateinit var category: Category;
    
    lateinit private var listView: ListView;
    
    lateinit private var listAdapter: MovieListAdapter;
    
    companion object {
        fun newInstance(category: Category): MovieListFragment {
            val fragment = MovieListFragment();
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
        configureComponents();
    }
    
    override fun configureComponents() {
        appComponent.inject(this);
        presenter.category = category;
        presenter.view = this;
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.movie_list_layout, container, false);
        listView = view.findViewById(android.R.id.list);
        
        return view;
    }
    
    override fun onStart() {
        super.onStart();
        presenter.onStart();
    }
    
    override fun onResume() {
        super.onResume();
    }
    
    override fun displayMovies(movies: List<Movie>) {
        listAdapter = MovieListAdapter(context, R.layout.movie_list_item, movies);
        listView.adapter = listAdapter;
    }
    
    override fun showUserError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    
}
