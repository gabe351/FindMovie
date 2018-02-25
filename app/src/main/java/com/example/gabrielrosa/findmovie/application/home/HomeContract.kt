package com.example.gabrielrosa.findmovie.application.home

import com.example.gabrielrosa.findmovie.application.common.entity.Movie

/**
 * Created by gabrielrosa on 24/02/18.
 */
interface HomeContract {

    interface View {
        fun showMovies(movie :List<Movie>)
        fun showNoMovies()

        fun showErrorMessage(errorMessage :String)

        fun showLoader()
        fun hideLoader()
    }

    interface Presenter {
        fun loadMovies(title :String)
    }

}