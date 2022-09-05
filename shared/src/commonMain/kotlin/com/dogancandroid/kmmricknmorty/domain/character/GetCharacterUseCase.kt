package com.dogancandroid.kmmricknmorty.domain.character

import com.dogancandroid.kmmricknmorty.base.map
import com.dogancandroid.kmmricknmorty.remote.IGetCharacter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * @author dogancankilic
 * Created on 4.09.2022
 */
class GetCharacterUseCase() : KoinComponent {

    private val dataSource: IGetCharacter by inject()
    private val mapper: CharacterMapper by inject()

    suspend fun invoke(endPoint: String) = dataSource.getCharacter(endPoint).map { response ->
        mapper.map(response)
    }
}
