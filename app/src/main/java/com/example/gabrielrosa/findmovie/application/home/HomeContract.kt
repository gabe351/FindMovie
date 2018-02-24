package com.example.gabrielrosa.findmovie.application.home

import com.example.gabrielrosa.findmovie.application.common.entity.Movie

/**
 * Created by gabrielrosa on 24/02/18.
 */
interface HomeContract {

    interface view {
        fun showMovies(movie :List<Movie>)
        fun showNoMovies()

        fun showErrorMessage(errorMessage :String)

        fun showLoader()
        fun hideLoader()
    }

    interface presenter {
        fun loadMovies(title :String)
    }

}