package com.example.gabrielrosa.findmovie.application.common.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by gabrielrosa on 24/02/18.
 */
data class Movie(@SerializedName("id") val id: Int,
                 @SerializedName("original_title") var originalTitle: String,
                 @SerializedName("backdrop_path") var backdropPath: String,
                 @SerializedName("overview") var overview: String)