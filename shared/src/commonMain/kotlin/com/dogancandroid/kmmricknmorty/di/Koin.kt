package com.dogancandroid.kmmricknmorty.di

import com.dogancandroid.kmmricknmorty.HttpBaseClient
import com.dogancandroid.kmmricknmorty.domain.character.CharacterMapper
import com.dogancandroid.kmmricknmorty.domain.character.GetCharacterUseCase
import com.dogancandroid.kmmricknmorty.remote.GetCharacterImpl
import com.dogancandroid.kmmricknmorty.remote.IGetCharacter
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * @author dogancankilic
 * Created on 3.09.2022
 */
fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(repositoryModule)
    }

// IOS
fun initKoin() = initKoin {}

val repositoryModule = module {
    single {
        HttpBaseClient()
    }
    single<IGetCharacter> { GetCharacterImpl(get()) }

    factory { CharacterMapper() }
    factory { GetCharacterUseCase(get(), get()) }
}
