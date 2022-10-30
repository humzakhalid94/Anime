package mhk.app.data.remote.datasource

data class Data(
    val count: Int,
    val current_page: Int,
    val documents: List<Document>,
    val last_page: Int
) {

    fun test() {
//        documents.map {
//
//        }
    }

}