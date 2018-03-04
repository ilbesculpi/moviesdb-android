package com.ilbesculpi.themoviedroid.ui.movies.detail


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.ilbesculpi.themoviedroid.ui.common.BaseFragmentView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_detail_layout.*
import javax.inject.Inject


class MovieDetailFragment : BaseFragmentView(), MovieDetail.View {
    
    @Inject
    override lateinit var presenter: MovieDetail.Presenter;
    
    companion object {
        fun newInstance(movie: Movie): MovieDetailFragment {
            val fragment = MovieDetailFragment();
            val args = Bundle();
            args.putSerializable("movie", movie);
            fragment.arguments = args;
            return fragment;
        }
    }
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.movie_detail_layout, container, false)
    }
    
    override fun configureComponents() {
        appComponent.inject(this);
        presenter.view = this;
        presenter.movie = arguments.getSerializable("movie") as Movie;
    }
    
    override fun onResume() {
        super.onResume();
        presenter.onResume();
    }
    
    override fun displayMovie(movie: Movie) {
        
        val posterUrl = Uri.parse(movie.posterUrl);
        Picasso.with(context)
                .load(posterUrl)
                .into(posterImage);
    
        title.text = movie.title;
    }

}
