package mhk.app.data.remote.datasource


data class AnimeDTO(
    val `data`: Data,
    val message: String,
    val status_code: Int,
    val version: String
)