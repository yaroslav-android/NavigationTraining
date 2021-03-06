package team.uptech.training.navigation.data.repository.tag

import kotlinx.coroutines.flow.Flow
import team.uptech.training.navigation.domain.model.PagedList


interface TagRepository {
  fun getTags(): Flow<PagedList<String>>
}