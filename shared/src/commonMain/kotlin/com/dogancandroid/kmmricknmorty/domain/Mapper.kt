package com.dogancandroid.kmmricknmorty.domain

interface Mapper <in Input, out Output> {
    fun map(input: Input): Output
}
