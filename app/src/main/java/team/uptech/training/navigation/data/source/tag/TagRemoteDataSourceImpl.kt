package team.uptech.training.navigation.data.source.tag

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.api.TagApi
import team.uptech.training.navigation.data.mappers.TagDataToDomainMapper
import team.uptech.training.navigation.domain.model.PagedList


class TagRemoteDataSourceImpl(
  private val ioDispatcher: CoroutineDispatcher,
  private val api: TagApi
) : TagRemoteDataSource {

  override fun getTags(): Flow<PagedList<String>> {
    return flow {
      val request = TagDataToDomainMapper.mapper.map(api.getTags())
      emit(request)
    }.flowOn(ioDispatcher)
  }
}