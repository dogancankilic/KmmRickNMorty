package com.dogancandroid.kmmricknmorty.remote

import com.dogancandroid.kmmricknmorty.HttpBaseClient
import com.dogancandroid.kmmricknmorty.base.ApiResult
import com.dogancandroid.kmmricknmorty.base.CustomException
import com.dogancandroid.kmmricknmorty.remote.model.CharacterResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

/**
 * @author dogancankilic
 * Created on 3.09.2022
 */
class GetCharacterImpl(private val httpBaseClient: HttpBaseClient) : IGetCharacter {
    override suspend fun getCharacter(
        endPoint: String
    ): ApiResult<CharacterResponse> {
        return try {
            val response = httpBaseClient.httpClient.get {
                url {
                    path(endPoint)
                }
            }.body<CharacterResponse>()
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error(e as CustomException)
        }
    }
}
