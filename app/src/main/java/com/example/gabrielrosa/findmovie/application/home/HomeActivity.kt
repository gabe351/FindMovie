package com.example.gabrielrosa.findmovie.application.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.gabrielrosa.findmovie.R

/**
 * Created by gabrielrosa on 24/02/18.
 */
class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.home_screen_container, HomeFragment(), this.javaClass.simpleName)
                .commit()
    }
}