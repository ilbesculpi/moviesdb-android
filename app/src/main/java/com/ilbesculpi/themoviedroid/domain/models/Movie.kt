package com.ilbesculpi.themoviedroid.domain.models

import java.util.*


class Movie {
    
    var id: Int? = null;
    var title: String? = null;
    var posterPath: String? = null;
    var backdropPath: String? = null;
    var adult: Boolean? = null;
    var overview: String? = null;
    var releaseDate: Date? = null;
    var genreIds: Array<Int>? = null;
    var originalTitle: String? = null;
    var originalLanguage: String? = null;
    var popularity: Float? = null;
    var voteCount: Int? = null;
    var video: Boolean? = null;
    var voteAverage: Float? = null;
    

}