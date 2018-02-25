package com.example.gabrielrosa.findmovie.infrastructure.remote.movie.remotedatasource

import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback

/**
 * Created by gabrielrosa on 25/02/18.
 */
interface MovieRemoteDataSource {

    fun loadMovies(query: String, apiCallback: BaseCallback.ApiCaseCallback<List<Movie>>)
    fun loadMovie(movieId: Int, apiCallback: BaseCallback.ApiCaseCallback<Movie>)

}