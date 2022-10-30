package mhk.app.data.remote

import mhk.app.data.remote.datasource.AnimeDTO
import mhk.app.domain.model.AnimeData
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface AnimeAPI {

    @GET("/v1/anime")
//    suspend fun getAnimeList() : AnimeDTO
    suspend fun getAnimeList() : List<AnimeData>

    @GET("v1/anime/{id}")
    suspend fun getAnimeById(@Path("id") id : String) : AnimeDTO
}