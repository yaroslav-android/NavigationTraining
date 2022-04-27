package team.uptech.training.navigation.data.repository.tag

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.repository.tag.logs.TagEvent
import team.uptech.training.navigation.data.source.tag.TagRemoteDataSource
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.utils.extensions.doOnError
import team.uptech.training.navigation.utils.logs.Logger


class TagRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: TagRemoteDataSource,
  private val logger: Logger
) : TagRepository {

  override fun getTags(): Flow<PagedList<String>> {
    return source.getTags()
      .doOnError { error ->
        val event = TagEvent(message = "all", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }
}