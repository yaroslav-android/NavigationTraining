package team.uptech.training.navigation.data.repository.post

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.source.post.PostRemoteDataSource
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.Post
import team.uptech.training.navigation.domain.model.PostPreview


class PostRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: PostRemoteDataSource
) : PostRepository {

  override fun getPosts(): Flow<PagedList<PostPreview>> {
    return source.getPosts()
      .flowOn(defaultDispatcher)
  }

  override fun getPostsByUser(userId: String): Flow<PagedList<PostPreview>> {
    return source.getPostsByUser(userId)
      .flowOn(defaultDispatcher)
  }

  override fun getPostsByTag(tag: String): Flow<PagedList<PostPreview>> {
    return source.getPostsByTag(tag)
      .flowOn(defaultDispatcher)
  }

  override fun getPost(id: String): Flow<Post> {
    return source.getPost(id)
      .flowOn(defaultDispatcher)
  }

  // TODO:
  //  createPost
  //  updatePost
  //  deletePost
}