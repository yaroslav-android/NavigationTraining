package team.uptech.training.navigation.data.repository.user

import kotlinx.coroutines.flow.Flow
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.User
import team.uptech.training.navigation.domain.model.UserPreview


interface UserRepository {
  fun getUsers(): Flow<PagedList<UserPreview>>
  fun getUser(id: String): Flow<User>
}