package com.ilbesculpi.themoviedroid

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when( item.itemId ) {
            R.id.menu_movies -> {
                message.setText(R.string.movies)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_tv_shows -> {
                message.setText(R.string.tv_shows)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    
}
