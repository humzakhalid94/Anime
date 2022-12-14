package mhk.app.anime_compose_clean_arch_mvvm_flow.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AnimeListScreen(
    viewModel: AnimeViewModel = hiltViewModel()
) {

    val animeState = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(animeState.animeList) {
                AnimeItemScreen(anime = it, modifier = Modifier.fillMaxWidth())
            }
        }

        if (animeState.error.isNotBlank()) {
            Text(
                text = animeState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .align(Alignment.Center)
            )

        }

        if (animeState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }


}