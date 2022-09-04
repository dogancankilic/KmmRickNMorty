package com.dogancandroid.kmmricknmorty

import com.dogancandroid.kmmricknmorty.base.BASE_URL
import com.dogancandroid.kmmricknmorty.base.CLIENT_REQUEST_EXCEPTION_RANGE
import com.dogancandroid.kmmricknmorty.base.CustomException
import com.dogancandroid.kmmricknmorty.base.ErrorResponse
import com.dogancandroid.kmmricknmorty.base.REDIRECT_RESPONSE_EXCEPTION_RANGE
import com.dogancandroid.kmmricknmorty.base.RESPONSE_EXCEPTION_CODE
import com.dogancandroid.kmmricknmorty.base.SERVER_RESPONSE_EXCEPTION_RANGE
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.engine.darwin.DarwinHttpRequestException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import platform.Foundation.setHTTPShouldUsePipelining

actual class HttpBaseClient {
    actual val httpClient: HttpClient = HttpClient(Darwin) {
        defaultRequest {
            url.takeFrom(
                URLBuilder().takeFrom(BASE_URL).apply {
                    encodedPath += url.encodedPath
                }
            )
            contentType(ContentType.Application.Json)
            url.protocol = URLProtocol.HTTPS
        }

        engine {
            // this: IosClientEngineConfig
            configureRequest {
                setHTTPShouldUsePipelining(true)
            }
        }

        // Validate Response
        expectSuccess = false
        // JSON Deserializer
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    encodeDefaults = true
                }
            )
        }

        HttpResponseValidator {
            validateResponse { response ->
                when (response.status.value) {
                    in REDIRECT_RESPONSE_EXCEPTION_RANGE -> throw RedirectResponseException(
                        response,
                        ""
                    )
                    in CLIENT_REQUEST_EXCEPTION_RANGE -> throw ClientRequestException(response, "")
                    in SERVER_RESPONSE_EXCEPTION_RANGE -> throw ServerResponseException(
                        response,
                        ""
                    )
                }
                if (response.status.value >= RESPONSE_EXCEPTION_CODE) {
                    throw ResponseException(response, "")
                }
            }
            handleResponseExceptionWithRequest { cause, request ->
                var error = ErrorResponse()
                when (cause) {
                    is ResponseException -> {
                        error.statusCode = cause.response.status.value
                    }
                    is DarwinHttpRequestException -> {
                        CustomException.getNoInternetError()
                    }
                    else -> CustomException.getDefaultError(cause.message)
                }
                throw CustomException(error)
            }
        }
    }
}
