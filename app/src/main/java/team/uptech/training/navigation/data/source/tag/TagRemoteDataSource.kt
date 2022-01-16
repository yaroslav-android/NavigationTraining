package team.uptech.training.navigation.data.source.tag

import kotlinx.coroutines.flow.Flow
import team.uptech.training.navigation.domain.model.PagedList


interface TagRemoteDataSource {
  fun getTags(): Flow<PagedList<String>>
}