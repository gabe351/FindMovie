package com.example.gabrielrosa.findmovie.infrastructure.model

import com.example.gabrielrosa.findmovie.application.common.entity.Movie
import com.google.gson.annotations.SerializedName

/**
 * Created by gabrielrosa on 24/02/18.
 */
data class MovieResponse(@SerializedName("page") val page: Int,
                         @SerializedName("total_results") val totalResults: Int,
                         @SerializedName("total_pages") val totalPages: Int,
                         @SerializedName("results") val results: List<Movie>)