package com.example.gabrielrosa.findmovie.infrastructure.remote.movie.remotedatasource

import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.example.gabrielrosa.findmovie.infrastructure.model.MovieDetailResponse
import com.example.gabrielrosa.findmovie.infrastructure.model.MovieResponse
import com.example.gabrielrosa.findmovie.infrastructure.remote.BaseCallback
import com.example.gabrielrosa.findmovie.infrastructure.remote.movie.apidatasource.MovieApiDataSourceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by gabrielrosa on 25/02/18.
 */
class MovieRemoteDataSourceImpl(private val api: MovieApiDataSourceImpl): MovieRemoteDataSource {

    private val API_KEY = "0bd449b4a197142635ab358c297053e6"

    override fun loadMovies(query: String, apiCallback: BaseCallback.ApiCaseCallback<List<Movie>>) {
        val call = api.build().loadMovies(API_KEY, query)

        call.enqueue(object : Callback<MovieResponse?> {
            override fun onResponse(call: Call<MovieResponse?>?, response: Response<MovieResponse?>?) {
                response.let {
                    if (it != null) {
                        if(it.body()?.results!!.isEmpty()) {
                            apiCallback.onEmptyData()
                        } else {
                            apiCallback.onSuccess(it.body()?.results!!)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MovieResponse?>?, t: Throwable?) {
                apiCallback.onError()
            }
        })
    }

    override fun loadMovie(movieId: Int, apiCallback: BaseCallback.ApiCaseCallback<MovieDetailResponse>) {
        val call = api.build().loadMovie(movieId, API_KEY)

        call.enqueue(object: Callback<MovieDetailResponse?> {
            override fun onResponse(call: Call<MovieDetailResponse?>?, response: Response<MovieDetailResponse?>?) {
                response.let {
                    if (it != null) {
                        apiCallback.onSuccess(it.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse?>?, t: Throwable?) {
                apiCallback.onError()
            }
        })
    }
}