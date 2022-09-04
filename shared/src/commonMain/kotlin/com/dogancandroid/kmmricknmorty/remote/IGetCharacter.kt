package com.dogancandroid.kmmricknmorty.remote

import com.dogancandroid.kmmricknmorty.base.ApiResult
import com.dogancandroid.kmmricknmorty.remote.model.CharacterResponse

interface IGetCharacter {
    suspend fun getCharacter(endPoint: String): ApiResult<CharacterResponse>
}
