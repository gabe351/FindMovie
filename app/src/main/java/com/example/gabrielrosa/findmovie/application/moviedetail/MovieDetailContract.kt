package com.example.gabrielrosa.findmovie.application.moviedetail

import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse

/**
 * Created by gabrielrosa on 25/02/18.
 */
interface MovieDetailContract {

    interface View {

        fun showMovie(movie: MovieDetailResponse)
        fun showError()

        fun showLoader()
        fun hideLoader()

    }

    interface Presenter {
        fun loadMovie(id: Int)
    }
}