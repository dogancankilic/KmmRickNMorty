package com.dogancandroid.kmmricknmorty.android

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author dogancankilic
 * Created on 3.09.2022
 */
val appModule = module {

    viewModel {
        MainViewModel(get())
    }
}
