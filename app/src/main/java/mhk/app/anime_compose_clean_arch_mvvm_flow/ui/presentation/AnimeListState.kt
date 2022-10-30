package mhk.app.anime_compose_clean_arch_mvvm_flow.ui.presentation

import mhk.app.domain.model.AnimeData
import java.util.*
import kotlin.collections.ArrayList


data class AnimeListState(
    val isLoading : Boolean = false,
    val animeList : List<AnimeData> = ArrayList(),
    val error : String = ""
)
