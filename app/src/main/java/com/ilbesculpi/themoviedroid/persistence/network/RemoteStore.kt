package com.ilbesculpi.themoviedroid.persistence.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ilbesculpi.themoviedroid.domain.models.Movie
import io.reactivex.Observable
import okhttp3.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteStore {
    
    var client: TheMovieDatabaseAPI;

    companion object {
        val API_URL: String = "https://api.themoviedb.org/3/";
        val API_KEY: String = "7f8661a70a2785177ff438102e23a9aa";
        val LANGUAGE: String = "en_US";
    }
    
    constructor() {
        client = initClient();
    }
    
    private fun initClient() : TheMovieDatabaseAPI {
        
        val gson: Gson = GsonBuilder()
                .setLenient()
                .create();
    
        val httpClient = OkHttpClient().newBuilder();
        
        httpClient.interceptors().add(object: Interceptor {
            override fun intercept(chain: Interceptor.Chain?): Response {
                var request: Request = chain!!.request();
                val url: HttpUrl = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build();
                request = request.newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            }
        });
        
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        
        val api: TheMovieDatabaseAPI = retrofit.create(TheMovieDatabaseAPI::class.java);
        
        return api;
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