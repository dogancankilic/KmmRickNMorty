package com.dogancandroid.kmmricknmorty.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dogancandroid.kmmricknmorty.base.ApiResult
import com.dogancandroid.kmmricknmorty.domain.character.CharacterUiModel
import com.dogancandroid.kmmricknmorty.domain.character.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author dogancankilic
 * Created on 3.09.2022
 */
class MainViewModel(private val getCharacterUseCase: GetCharacterUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    fun getCharacter() = viewModelScope.launch {

        when (val response = getCharacterUseCase.invoke("api/character/1")) {
            is ApiResult.Success -> {
                _uiState.update {
                    UiState.Success(response.data)
                }
            }
            is ApiResult.Error -> {
                response.error?.printStackTrace().toString()
            }
            else -> {}
        }
    }

    sealed interface UiState {
        data class Success(val data: CharacterUiModel) : UiState
        object Loading : UiState
        object Error : UiState
    }
}
