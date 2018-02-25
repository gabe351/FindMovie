package com.example.gabrielrosa.findmovie.application.moviedetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.gabrielrosa.findmovie.R

/**
 * Created by gabrielrosa on 25/02/18.
 */
class MovieDetailActivity: AppCompatActivity() {

    companion object {
        val MOVIE_ID = "MOVIE_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_actitivity)

        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.movieDetailContent, MovieDetailFragment(), this.javaClass.simpleName)
                .commit()
    }
}