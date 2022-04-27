package team.uptech.training.navigation.data.repository.post

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import team.uptech.training.navigation.data.repository.post.logs.PostEvent
import team.uptech.training.navigation.data.source.post.PostRemoteDataSource
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.Post
import team.uptech.training.navigation.domain.model.PostPreview
import team.uptech.training.navigation.utils.extensions.doOnError
import team.uptech.training.navigation.utils.logs.Logger


class PostRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: PostRemoteDataSource,
  private val logger: Logger
) : PostRepository {

  override fun getPosts(): Flow<PagedList<PostPreview>> {
    return source.getPosts()
      .doOnError { error ->
        val event = PostEvent(message = "all", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }

  override fun getPostsByUser(userId: String): Flow<PagedList<PostPreview>> {
    return source.getPostsByUser(userId)
      .doOnError { error ->
        val event = PostEvent(message = "byUser", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }

  override fun getPostsByTag(tag: String): Flow<PagedList<PostPreview>> {
    return source.getPostsByTag(tag)
      .doOnError { error ->
        val event = PostEvent(message = "byTag", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }

  override fun getPost(id: String): Flow<Post> {
    return source.getPost(id)
      .doOnError { error ->
        val event = PostEvent(message = "byPost", exception = error)
        logger.log(event)
      }.flowOn(defaultDispatcher)
  }

  // TODO:
  //  createPost
  //  updatePost
  //  deletePost
}