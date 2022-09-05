@file:OptIn(ExperimentalLifecycleComposeApi::class)

package com.dogancandroid.kmmricknmorty.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.dogancandroid.kmmricknmorty.domain.character.CharacterUiModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainLayout()
            }
        }
    }
}

@Composable
fun MainLayout() {
    val viewModel = getViewModel<MainViewModel>()
    viewModel.getCharacter()
    val state: MainViewModel.UiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (val result = state) {
        is MainViewModel.UiState.Success -> {
            CharacterCard(character = result.data)
        }
        else -> {}
    }
}

@Composable
fun CharacterCard(character: CharacterUiModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            character.name,
            textAlign = TextAlign.Center,
            color = LocalContentColor.current,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            modifier = Modifier.size(300.dp)
                .clip(RoundedCornerShape(20.dp))
        )
    }
}
