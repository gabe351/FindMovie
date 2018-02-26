package com.example.gabrielrosa.findmovie.application.common.utils

/**
 * Created by gabrielrosa on 25/02/18.
 */
class BuildImageUrl {

    companion object {
        fun build(path: String): String {
            val imageBaseUrl: String = "https://image.tmdb.org/t/p/w780"
            val stringBuilder = StringBuilder()

            stringBuilder.append(imageBaseUrl).append(path)

            return stringBuilder.toString()
        }
    }
}