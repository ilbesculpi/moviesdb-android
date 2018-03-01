package com.ilbesculpi.themoviedroid.ui.movies.list

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Movie
import com.squareup.picasso.Picasso
import java.text.DateFormat
import java.text.SimpleDateFormat


class MovieListAdapter(context: Context, resourceId: Int, var objects: List<Movie>)
    : ArrayAdapter<Movie>(context, resourceId, objects) {
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        
        val row: View;
        val viewHolder: MovieViewHolder;
        
        if( convertView == null ) {
            row = LayoutInflater.from(context)
                    .inflate(R.layout.movie_list_item, parent, false);
            viewHolder = MovieViewHolder(row);
            row.tag = viewHolder;
        }
        else {
            row = convertView;
            viewHolder = row.tag as MovieViewHolder;
        }
        
        val movie: Movie = getItem(position);
        viewHolder.display(movie, context);
        return row;
    }
    
    override fun getItem(position: Int): Movie {
        return objects[position];
    }
    
    override fun getCount(): Int {
        return objects.size;
    }
    
    private class MovieViewHolder(rootView: View) {
        
        var imageView: ImageView;
        var titleLabel: TextView;
        var dateLabel: TextView;
        var popularityLabel: TextView;
        
        init {
            imageView = rootView.findViewById(R.id.image);
            titleLabel = rootView.findViewById(R.id.title);
            dateLabel = rootView.findViewById(R.id.date);
            popularityLabel = rootView.findViewById(R.id.popularity);
        }
        
        fun display(movie: Movie, context: Context) {
            //imageView.setImageResource(movie.iconId);
            titleLabel.text = movie.title;
            dateLabel.text = DateFormat.getDateInstance().format(movie.releaseDate);
            popularityLabel.text = movie.popularityText;
            // download image using picasso
            val posterUri = Uri.parse(movie.posterUrl);
            Picasso.with(context)
                    .load(posterUri)
                    .placeholder(R.drawable.placeholder)
                    .into(imageView);
        }
        
    }
    
}