package com.example.gabrielrosa.findmovie.application.common.utils

import org.junit.Assert
import org.junit.Test

/**
 * Created by gabrielrosa on 27/02/18.
 */
class BuildImageUrlTest {

    @Test
    fun check_if_building_correctly() {
        val url = BuildImageUrl.build("/testPath")
        val expected = "https://image.tmdb.org/t/p/w780/testPath"

        Assert.assertEquals(expected, url)
    }
}