package com.dogancandroid.kmmricknmorty.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CharacterResponse {
    @SerialName("created")
    val created: String? = null
    @SerialName("episode")
    val episode: List<String?>? = null
    @SerialName("gender")
    val gender: String? = null
    @SerialName("id")
    val id: Int? = null
    @SerialName("image")
    val image: String? = null
    @SerialName("location")
    val location: Location? = null
    @SerialName("name")
    val name: String? = null
    @SerialName("origin")
    val origin: Origin? = null
    @SerialName("species")
    val species: String? = null
    @SerialName("status")
    val status: String? = null
    @SerialName("type")
    val type: String? = null
    @SerialName("url")
    val url: String? = null
    @Serializable
    class Location {
        @SerialName("name")
        val name: String? = null
        @SerialName("url")
        val url: String? = null
    }

    @Serializable
    class Origin {
        @SerialName("name")
        val name: String? = null
        @SerialName("url")
        val url: String? = null
    }
}
