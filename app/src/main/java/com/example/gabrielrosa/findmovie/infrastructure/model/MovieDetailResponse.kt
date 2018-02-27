package com.example.gabrielrosa.findmovie.infrastructure.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by gabrielrosa on 24/02/18.
 */

data class MovieDetailResponse(@SerializedName("id") val id: Int,
                               @SerializedName("backdrop_path") val backdropPath: String,
                               @SerializedName("original_title") val originalTitle: String,
                               @SerializedName("overview") val overview: String,
                               @SerializedName("status") val status: String,
                               @SerializedName("production_companies") val productionResponse: List<ProductionResponse>,
                               @SerializedName("release_date") val releaseDate: Date)