package team.uptech.training.navigation.data.source.post

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.api.PostApi
import team.uptech.training.navigation.data.mappers.PostDataToDomainMapper
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.PostPreview


class PostRemoteDataSourceImpl(
  private val ioDispatcher: CoroutineDispatcher,
  private val api: PostApi
) : PostRemoteDataSource {

  override fun getPosts(): Flow<PagedList<PostPreview>> {
    return flow {
      val response = PostDataToDomainMapper.postPreviewMapper.map(api.getPosts())
      emit(response)
    }.flowOn(ioDispatcher)
  }

  // TODO:
  //  getPostsByUser
  //  getPostsByTag
  //  getPost
  //  createPost
  //  updatePost
  //  deletePost
}