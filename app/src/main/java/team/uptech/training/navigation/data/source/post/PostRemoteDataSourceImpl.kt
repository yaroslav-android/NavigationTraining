package team.uptech.training.navigation.data.source.post

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.api.PostApi
import team.uptech.training.navigation.data.mappers.PostDataToDomainMapper
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.Post
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

  override fun getPostsByUser(userId: String): Flow<PagedList<PostPreview>> {
    return flow {
      val response = PostDataToDomainMapper.postPreviewMapper.map(api.getPostsByUser(userId))
      emit(response)
    }.flowOn(ioDispatcher)
  }

  override fun getPostsByTag(tag: String): Flow<PagedList<PostPreview>> {
    return flow {
      val response = PostDataToDomainMapper.postPreviewMapper.map(api.getPostsByTag(tag))
      emit(response)
    }.flowOn(ioDispatcher)
  }

  override fun getPost(id: String): Flow<Post> {
    return flow {
      val response = PostDataToDomainMapper.postModelMapper.map(api.getPost(id))
      emit(response)
    }.flowOn(ioDispatcher)
  }

  // TODO:
  //  createPost
  //  updatePost
  //  deletePost
}