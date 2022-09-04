package com.dogancandroid.kmmricknmorty

import io.ktor.client.HttpClient

expect class HttpBaseClient() {
    val httpClient: HttpClient
}
