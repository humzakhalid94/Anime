package mhk.app.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mhk.app.domain.Events
import mhk.app.domain.model.AnimeData
import mhk.app.domain.repository.AnimeRepository
import java.io.IOException
import javax.inject.Inject
import java.util.*

class AnimeGetUseCase @Inject constructor(
    private val repository: AnimeRepository
) {
//    operator fun invoke() : Flow<Events<List<AnimeData>>> = flow{
//        try{
//            emit(Events.Loading<List<AnimeData>>())
//
//            val list = listOf("asd")
//
//            val animeData = repository.getAnimeList().data.documents.map {
//                it.toAnimeData()
//            }
//            emit(Events.Success<List<AnimeData>>(animeData))
//        }
//        catch (e: HttpException){
//            emit(Events.Error<List<AnimeData>>(message = e.localizedMessage?:"An Unexpected Error Occurred"))
//        }
//        catch (e: IOException){
//            emit(Events.Error<List<AnimeData>>(message = "Could Not Reach the server due to Internet Connection Loss"))
//        }
//    }

    suspend operator fun invoke() : Flow<Events<List<AnimeData>>> = repository.getAnimeList()

}