package team.uptech.training.navigation.data.repository.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.repository.user.logs.UserEvent
import team.uptech.training.navigation.data.source.user.UserRemoteDataSource
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.User
import team.uptech.training.navigation.domain.model.UserPreview
import team.uptech.training.navigation.utils.extensions.doOnError
import team.uptech.training.navigation.utils.logs.Logger


class UserRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: UserRemoteDataSource,
  private val logger: Logger
) : UserRepository {
  override fun getUsers(): Flow<PagedList<UserPreview>> {
    return source.getUsers()
      .doOnError { error ->
        val event = UserEvent(message = "all", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }

  override fun getUser(id: String): Flow<User> {
    return source.getUser(id)
      .doOnError { error ->
        val event = UserEvent(message = "get", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }
}