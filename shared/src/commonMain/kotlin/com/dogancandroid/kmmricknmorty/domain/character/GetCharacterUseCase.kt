package com.dogancandroid.kmmricknmorty.domain.character

import com.dogancandroid.kmmricknmorty.base.map
import com.dogancandroid.kmmricknmorty.remote.IGetCharacter

/**
 * @author dogancankilic
 * Created on 4.09.2022
 */
class GetCharacterUseCase(
    private val dataSource: IGetCharacter,
    private val characterMapper: CharacterMapper
) {
    suspend fun invoke(endPoint: String) = dataSource.getCharacter(endPoint).map { response ->
        characterMapper.map(response)
    }
}
