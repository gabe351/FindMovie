package com.example.gabrielrosa.findmovie.infrastructure.model

import com.google.gson.annotations.SerializedName

/**
 * Created by gabrielrosa on 26/02/18.
 */

data class ProductionResponse(@SerializedName("id") val id: Int,
                              @SerializedName("name") val name: String)