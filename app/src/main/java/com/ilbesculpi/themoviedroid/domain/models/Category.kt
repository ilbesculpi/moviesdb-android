package com.ilbesculpi.themoviedroid.domain.models

import com.ilbesculpi.themoviedroid.R

enum class Category {

    POPULAR,
    TOP_RATED,
    UPCOMING;
    
    val titleId: Int
        get() {
            return when( this ) {
                POPULAR -> R.string.popular;
                TOP_RATED -> R.string.top_rated;
                UPCOMING -> R.string.upcoming;
            }
        };
    
    val iconId: Int
    get() {
        return when( this ) {
            POPULAR -> R.drawable.icon_popular;
            TOP_RATED -> R.drawable.icon_top_rated;
            UPCOMING -> R.drawable.icon_upcoming;
        }
    }
    
}