package com.example.gabrielrosa.findmovie.infrastructure.remote

/**
 * Created by gabrielrosa on 24/02/18.
 */
class BaseCallback {
    interface ApiCaseCallback<R> {
        fun onSuccess(response: R)
        fun onEmptyData()
        fun onError()
    }
}