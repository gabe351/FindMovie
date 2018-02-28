package com.example.gabrielrosa.findmovie.application.common.entity

import com.example.gabrielrosa.findmovie.application.common.utils.BuildImageUrl
import org.junit.Assert
import org.junit.Test

/**
 * Created by gabrielrosa on 27/02/18.
 */
class MovieTest {

    private val movie = Movie(11, "Duro de matar","imagePath", "This is a base description to my movie")

    @Test
    fun check_if_movie_id_get_correctly() {
        val expected = 11

        Assert.assertEquals(movie.id, expected)
    }

    @Test
    fun check_if_movie_title_get_correctly() {
        val expected = "Duro de matar"

        Assert.assertEquals(movie.originalTitle, expected)
    }

    @Test
    fun check_if_movie_path_get_correctly() {
        val expected = "imagePath"

        Assert.assertEquals(movie.backdropPath, expected)
    }

    @Test
    fun check_if_movie_review_get_correctly() {
        val expected = "This is a base description to my movie"

        Assert.assertEquals(movie.overview, expected)
    }
}