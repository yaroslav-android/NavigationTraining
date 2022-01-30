package team.uptech.training.navigation.data.source.user

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.api.UserApi
import team.uptech.training.navigation.data.mappers.UserDataToDomainMapper
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.User
import team.uptech.training.navigation.domain.model.UserPreview


class UserRemoteDataSourceImpl(
  private val ioDispatcher: CoroutineDispatcher,
  private val api: UserApi
) : UserRemoteDataSource {

  override fun getUsers(): Flow<PagedList<UserPreview>> {
    return flow {
      val response = UserDataToDomainMapper.userListMapper.map(api.getUsers())
      emit(response)
    }.flowOn(ioDispatcher)
  }

  override fun getUser(id: String): Flow<User> {
    return flow {
      val response = UserDataToDomainMapper.userModelMapper.map(api.getUser(id))
      emit(response)
    }.flowOn(ioDispatcher)
  }
}