package com.ilbesculpi.themoviedroid.persistence.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ilbesculpi.themoviedroid.domain.models.Movie
import io.reactivex.Observable
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteStore {
    
    var client: TheMovieDatabaseAPI;

    companion object {
        val API_URL: String = "https://api.themoviedb.org/3/";
        val LANGUAGE: String = "en_US";
    }
    
    constructor() {
        client = initClient();
    }
    
    private fun initClient() : TheMovieDatabaseAPI {
        
        val gson: Gson = GsonBuilder()
                .setLenient()
                .create();
        
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        
        val client: TheMovieDatabaseAPI = retrofit.create(TheMovieDatabaseAPI::class.java);
        
        return client;
    }
    
    fun popularMovies(page: Int) : Observable<MovieListResponse> {
        return Observable.create({ subscriber ->
            doAsync {
                val call: Call<MovieListResponse> = client.popularMovies(page, LANGUAGE);
                val response = call.execute();
                uiThread {
                    subscriber.onNext(response.body()!!);
                }
            }
        });
    }
    
    fun topRatedMovies(page: Int) : Observable<MovieListResponse> {
        return Observable.create({ subscriber ->
            doAsync {
                val call: Call<MovieListResponse> = client.topRatedMovies(page, LANGUAGE);
                val response = call.execute();
                uiThread {
                    subscriber.onNext(response.body()!!);
                }
            }
        });
    }
    
    fun upcomingMovies(page: Int) : Observable<MovieListResponse> {
        return Observable.create({ subscriber ->
            doAsync {
                val call: Call<MovieListResponse> = client.upcomingMovies(page, LANGUAGE);
                val response = call.execute();
                uiThread {
                    subscriber.onNext(response.body()!!);
                }
            }
        });
    }

}