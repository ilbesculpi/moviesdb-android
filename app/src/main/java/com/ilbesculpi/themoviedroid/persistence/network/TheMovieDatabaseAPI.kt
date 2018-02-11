package com.ilbesculpi.themoviedroid.persistence.network

import com.ilbesculpi.themoviedroid.domain.models.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDatabaseAPI {
    
    @GET("movie/popular")
    fun popularMovies(@Query("page") page: Int, @Query("language") language: String) : Call<MovieListResponse>;
    
    @GET("movie/top_rated")
    fun topRatedMovies(@Query("page") page: Int, @Query("language") language: String) : Call<MovieListResponse>;
    
    @GET("movie_upcoming")
    fun upcomingMovies(@Query("page") page: Int, @Query("language") language: String) : Call<MovieListResponse>;

}

class MovieListResponse {

    var page: Int? = null;
    var results: Array<Movie>? = null;
    var totalPages: Int? = null;
    var totalResults: Int? = null;

}