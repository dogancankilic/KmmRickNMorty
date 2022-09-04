package com.dogancandroid.kmmricknmorty.domain.character

import com.dogancandroid.kmmricknmorty.domain.Mapper
import com.dogancandroid.kmmricknmorty.remote.model.CharacterResponse

/**
 * @author dogancankilic
 * Created on 4.09.2022
 */
class CharacterMapper :
    Mapper<CharacterResponse, CharacterUiModel> {
    override fun map(input: CharacterResponse): CharacterUiModel {
        return CharacterUiModel(input.id ?: 0, input.name.toString(), input.image.toString())
    }
}
