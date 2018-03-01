package com.ilbesculpi.themoviedroid.domain.models

import com.google.gson.annotations.SerializedName
import java.util.*


class Movie {
    
    var id: Int? = null;
    
    var title: String? = null;
    
    @SerializedName("poster_path")
    var posterPath: String? = null;
    
    @SerializedName("backdrop_path")
    var backdropPath: String? = null;
    
    var adult: Boolean? = null;
    
    var overview: String? = null;
    
    @SerializedName("release_date")
    var releaseDate: Date? = null;
    
    var genreIds: Array<Int>? = null;
    
    @SerializedName("original_title")
    var originalTitle: String? = null;
    
    @SerializedName("original_language")
    var originalLanguage: String? = null;
    
    var popularity: Float? = null;
    
    @SerializedName("vote_count")
    var voteCount: Int? = null;
    
    var video: Boolean? = null;
    
    @SerializedName("vote_average")
    var voteAverage: Float? = null;
    
    val popularRate: Int?
        get() {
            if( voteAverage != null ) {
                return (voteAverage!! * 10.0f).toInt();
            }
            return null;
        }
    
    val popularityText: String get() {
        return popularRate.toString() + "%";
    }
    
    val posterUrl: String?
        get() {
            if( posterPath != null ) {
                return "https://image.tmdb.org/t/p/w185_and_h278_bestv2" + posterPath
            }
            return null;
        }
}