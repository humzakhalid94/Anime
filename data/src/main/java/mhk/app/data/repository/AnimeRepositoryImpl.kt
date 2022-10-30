package mhk.app.data.repository

import mhk.app.data.repository.datasource.AnimeRemoteSource
import mhk.app.domain.repository.AnimeRepository
import retrofit2.HttpException
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mhk.app.domain.Events
import mhk.app.domain.model.AnimeData
import java.util.*


class AnimeRepositoryImpl(val animeRemoteSource: AnimeRemoteSource) : AnimeRepository {

//    override fun getAnimeList() = animeRemoteSource.getAnimeList()

    override suspend fun getAnimeList() : Flow<Events<List<AnimeData>>> = flow{
        try{
            emit(Events.Loading<List<AnimeData>>())
            val animeData = animeRemoteSource.getAnimeList()
//            val animeData = animeRemoteSource.getAnimeList().map {
//                it.toAnimeData()
//            }
            emit(Events.Success<List<AnimeData>>(animeData))
        }
        catch (e: HttpException){
            emit(Events.Error<List<AnimeData>>(message = e.localizedMessage?:"An Unexpected Error Occurred"))
        }
        catch (e: IOException){
            emit(Events.Error<List<AnimeData>>(message = "Could Not Reach the server due to Internet Connection Loss"))
        }
    }
}