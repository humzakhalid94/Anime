package mhk.app.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import mhk.app.data.remote.AnimeAPI
import mhk.app.data.repository.datasource.AnimeRemoteSource
import mhk.app.data.repository.datasource.AnimeRemoteSourceImpl
import mhk.app.data.util.Constants
import mhk.app.domain.repository.AnimeRepository
import mhk.app.data.repository.AnimeRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
object AnimeModule {

    @Provides
    @Singleton
    fun provideApi(): AnimeAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeRemoteSource(api: AnimeAPI) : AnimeRemoteSource{
        return AnimeRemoteSourceImpl(api)
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(animeRemoteSource: AnimeRemoteSource) : AnimeRepository {
        return AnimeRepositoryImpl(animeRemoteSource)
    }


}