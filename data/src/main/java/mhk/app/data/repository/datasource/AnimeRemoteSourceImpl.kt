package mhk.app.data.repository.datasource

import mhk.app.data.remote.AnimeAPI
import mhk.app.domain.model.AnimeData

class AnimeRemoteSourceImpl(val animeAPI: AnimeAPI): AnimeRemoteSource {
    override suspend fun getAnimeList() : List<AnimeData> = animeAPI.getAnimeList()
}