package com.dogancandroid.kmmricknmorty.di

import com.dogancandroid.kmmricknmorty.Greeting
import com.dogancandroid.kmmricknmorty.HttpBaseClient
import com.dogancandroid.kmmricknmorty.domain.character.CharacterMapper
import com.dogancandroid.kmmricknmorty.domain.character.GetCharacterUseCase
import com.dogancandroid.kmmricknmorty.remote.GetCharacterImpl
import com.dogancandroid.kmmricknmorty.remote.IGetCharacter
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
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
fun initKoin() = initKoin {
}

fun httpClient() = HttpClient {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
            }
        )
    }
}

val repositoryModule = module {
    single {
        HttpBaseClient()
    }

    single {
        httpClient()
    }
    single<IGetCharacter> { GetCharacterImpl(get()) }

    factory { CharacterMapper() }
    factory { GetCharacterUseCase() }
    single { Greeting() }
}
