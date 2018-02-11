package com.ilbesculpi.themoviedroid.persistence.network

import com.ilbesculpi.themoviedroid.domain.models.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDatabaseAPI {
    
    @GET("movie/popular?page={page}&language={language}")
    fun popularMovies(@Path("page") page: Int, @Path("language") language: String) : Call<MovieListResponse>;
    
    @GET("movie/top_rated?page={page}&language={language}\"")
    fun topRatedMovies(@Path("page") page: Int, @Path("language") language: String) : Call<MovieListResponse>;
    
    @GET("movie_upcoming?page={page}&language={language}\"")
    fun upcomingMovies(@Path("page") page: Int, @Path("language") language: String) : Call<MovieListResponse>;

}

class MovieListResponse {

    var page: Int? = null;
    var results: Array<Movie>? = null;
    var totalPages: Int? = null;
    var totalResults: Int? = null;

}