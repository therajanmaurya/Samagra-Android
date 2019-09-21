package com.example.samagra.android.api

import com.example.samagra.android.BuildConfig

object BaseUrl {

    private const val PROTOCOL_HTTPS = "https://"

    // "/" in the last of the base url always
    private const val API_TEST_ENDPOINT = "jsonplaceholder.typicode.com/"
    private const val API_PRODUCTION_ENDPOINT = "jsonplaceholder.typicode.com/"

    val defaultBaseUrl: String
        get() = "$PROTOCOL_HTTPS$apiEndpoint"

    private val apiEndpoint: String
        get() = if (BuildConfig.DEBUG) {
            API_TEST_ENDPOINT
        } else {
            API_PRODUCTION_ENDPOINT
        }
}
