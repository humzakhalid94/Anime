package mhk.app.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class Events<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Events<T>(data)
    class Error<T>(data: T? = null, message: String?) : Events<T>(data = data, message = message)
    class Loading<T>(data: T? = null) : Events<T>(data)

}



//inline fun <T> repoFlow(
//    crossinline block: suspend () -> T,
//): Flow<Events<T>> = flow {
//    try {
//        val repoResult = block()
//        emit(Events.Success(repoResult))
//    } catch (e: Exception) {
//        emit(Events.Error(e.message ?: "Unknown error"))
//    }
//}