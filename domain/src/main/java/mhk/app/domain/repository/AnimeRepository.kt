package mhk.app.domain.repository

import kotlinx.coroutines.flow.Flow
import mhk.app.domain.Events
import mhk.app.domain.model.AnimeData
import java.util.*

interface AnimeRepository {

    suspend fun getAnimeList() : Flow<Events<List<AnimeData>>>
//    suspend fun getAnimeById(id:String) : Flow<Events<List<AnimeData>>>

}