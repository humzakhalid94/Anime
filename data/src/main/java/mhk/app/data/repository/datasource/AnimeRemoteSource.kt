package mhk.app.data.repository.datasource

import kotlinx.coroutines.flow.Flow
import mhk.app.domain.Events
import mhk.app.domain.model.AnimeData
import java.util.*

interface AnimeRemoteSource {
    suspend fun getAnimeList() : List<AnimeData>
}