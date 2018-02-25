package com.example.gabrielrosa.findmovie.infrastructure.remote.movie.apidatasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gabrielrosa on 25/02/18.
 */
class MovieApiDataSourceImpl private constructor() {

    init { println("This ($this) is a singleton") }

    private object Holder { val INSTANCE = MovieApiDataSourceImpl() }

    companion object {
        val instance: MovieApiDataSourceImpl by lazy { Holder.INSTANCE }
    }

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun build(): MovieApiDataSource {
        return retrofit.create(MovieApiDataSource::class.java)
    }
}