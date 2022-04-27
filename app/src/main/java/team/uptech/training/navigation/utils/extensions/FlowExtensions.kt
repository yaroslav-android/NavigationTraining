package team.uptech.training.navigation.utils.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun <T> Flow<T>.doOnError(onError: (Throwable) -> Unit): Flow<T> {
  return flow {
    try {
      collect { value -> emit(value) }
    } catch (e: Exception) {
      onError(e)
    }
  }
}