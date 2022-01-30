package team.uptech.training.navigation.data.repository.post

import kotlinx.coroutines.CoroutineDispatcher
import team.uptech.training.navigation.data.source.post.PostRemoteDataSource


class PostRepositoryImpl(
  private val defaultDispatcher: CoroutineDispatcher,
  private val source: PostRemoteDataSource
) : PostRepository {

  // TODO: getPosts
  //  getPostsByUser
  //  getPostsByTag
  //  getPost
  //  createPost
  //  updatePost
  //  deletePost
}