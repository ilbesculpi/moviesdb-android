package com.ilbesculpi.themoviedroid.ui.movies.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.persistence.interactors.MovieInteractorImpl
import com.ilbesculpi.themoviedroid.persistence.network.RemoteStore
import com.ilbesculpi.themoviedroid.ui.common.BaseFragmentView
import javax.inject.Inject
import kotlin.text.Typography.section

/**
 * Movie List Screen.
 */
class MovieListFragment : BaseFragmentView(), MovieList.View {
    
    @Inject
    lateinit var presenter: MovieList.Presenter;
    
    lateinit var category: Category;
    
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
        configureComponents();
        if(arguments != null) {
            category = arguments.getSerializable("category") as Category;
        }
    }
    
    override fun configureComponents() {
        appComponent.inject(this);
        presenter.category = category;
        presenter.view = this;
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.movie_list_layout, container, false);
    }
    
    override fun onStart() {
        super.onStart();
        presenter.onViewReady();
    }
    
    override fun onResume() {
        super.onResume();
    }
    
    override fun displayMovies(movies: List<Movie>) {
        showUserError("Movie List: " + movies.size);
    }
    
    override fun showUserError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    
}
