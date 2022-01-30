package team.uptech.training.navigation.data.repository.post

import kotlinx.coroutines.flow.Flow
import team.uptech.training.navigation.domain.model.PagedList
import team.uptech.training.navigation.domain.model.Post
import team.uptech.training.navigation.domain.model.PostPreview


interface PostRepository {
  fun getPosts(): Flow<PagedList<PostPreview>>
  fun getPostsByUser(userId: String): Flow<PagedList<PostPreview>>
  fun getPostsByTag(tag: String): Flow<PagedList<PostPreview>>
  fun getPost(id: String): Flow<Post>
}