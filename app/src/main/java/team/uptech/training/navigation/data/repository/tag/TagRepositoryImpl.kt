package team.uptech.training.navigation.data.repository.tag

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.source.tag.TagRemoteDataSource
import team.uptech.training.navigation.domain.model.PagedList


class TagRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: TagRemoteDataSource
) : TagRepository {

  override fun getTags(): Flow<PagedList<String>> {
    return source.getTags()
      .flowOn(defaultDispatcher)
  }
}