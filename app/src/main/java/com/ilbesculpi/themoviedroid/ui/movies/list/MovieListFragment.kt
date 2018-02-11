package com.ilbesculpi.themoviedroid.ui.movies.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.persistence.interactors.MovieInteractorImpl
import com.ilbesculpi.themoviedroid.persistence.network.RemoteStore
import javax.inject.Inject

/**
 * Movie List Screen.
 */
class MovieListFragment : Fragment(), MovieList.View {
    
    @Inject
    lateinit var presenter: MovieList.Presenter;
    
    companion object {
        fun newInstance(): MovieListFragment {
            val fragment = MovieListFragment();
            val args = Bundle();
            fragment.arguments = args;
            return fragment;
        }
    }
    
    fun configurePresenter() : MovieListPresenter {
        val presenter = MovieListPresenter();
        val interactor = MovieInteractorImpl();
        interactor.remoteStore = RemoteStore();
        presenter.interactor = interactor;
        return presenter;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        presenter = configurePresenter();
        presenter.view = this;
        if(arguments != null) {
        
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.movie_list_layout, container, false);
    }
    
    override fun onStart() {
        super.onStart();
    }
    
    override fun onResume() {
        super.onResume();
        presenter.onViewReady();
    }
    
    override fun displayMovies(movies: List<Movie>) {
        showUserError("Movie List: " + movies.size);
    }
    
    override fun showUserError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    
}
