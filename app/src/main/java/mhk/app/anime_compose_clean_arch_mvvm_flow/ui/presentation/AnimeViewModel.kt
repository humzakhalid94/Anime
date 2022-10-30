package mhk.app.anime_compose_clean_arch_mvvm_flow.ui.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mhk.app.domain.Events
import mhk.app.domain.model.AnimeData
import mhk.app.domain.usecase.AnimeGetUseCase
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeUseCase: AnimeGetUseCase
) : ViewModel() {

    private val stateAnime = mutableStateOf(AnimeListState())
    val state: State<AnimeListState> = stateAnime

    init {
        getAnimeList()
    }

    private fun getAnimeList() = viewModelScope.launch {

        animeUseCase().onEach {
            when (it) {
                is Events.Success -> {
                    stateAnime.value = AnimeListState(animeList = it.data ?: ArrayList<AnimeData>())
                }
                is Events.Loading -> {
                    stateAnime.value = AnimeListState(isLoading = true)
                }
                is Events.Error -> {
                    stateAnime.value = AnimeListState(error = it.message ?: "An Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }


}

