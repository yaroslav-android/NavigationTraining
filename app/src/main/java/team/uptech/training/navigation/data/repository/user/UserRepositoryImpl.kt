package team.uptech.training.navigation.data.repository.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.source.user.UserRemoteDataSource
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.User
import team.uptech.training.navigation.domain.model.UserPreview


class UserRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: UserRemoteDataSource
) : UserRepository {
  override fun getUsers(): Flow<PagedList<UserPreview>> {
    return source.getUsers()
      .flowOn(defaultDispatcher)
  }

  override fun getUser(id: String): Flow<User> {
    return source.getUser(id)
      .flowOn(defaultDispatcher)
  }
}