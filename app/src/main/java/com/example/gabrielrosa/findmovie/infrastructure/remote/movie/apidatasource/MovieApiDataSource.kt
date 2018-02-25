package com.example.gabrielrosa.findmovie.infrastructure.remote.movie.apidatasource

import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse
import com.example.gabrielrosa.findmovie.infrastructure.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by gabrielrosa on 24/02/18.
 */
interface MovieApiDataSource {

    @GET("movie/{movie_id}")
    fun loadMovie(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String): Call<MovieDetailResponse>

    @GET("search/movie")
    fun loadMovies(@Query("api_key") apiKey: String, @Query("query") query: String): Call<MovieResponse>

}