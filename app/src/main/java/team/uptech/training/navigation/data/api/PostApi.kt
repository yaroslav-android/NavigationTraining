package team.uptech.training.navigation.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.*
import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.NewPost
import team.uptech.training.navigation.data.model.Post
import team.uptech.training.navigation.data.model.PostPreview


interface PostApi {

  @GET("post")
  fun getPosts(): Flow<DataList<PostPreview>>

  @GET("user/{id}/post")
  fun getPostsByUser(@Path("id") id: String): Flow<DataList<PostPreview>>

  @GET("user/{id}/tag")
  fun getPostsByTag(@Path("tag") tag: String): Flow<DataList<PostPreview>>

  @GET("post/{id}")
  fun getPost(@Path("id") id: String): Flow<Post>

  @POST("post/create")
  fun createPost(post: NewPost): Flow<Post>

  /**
   * owner is forbidden for update.
   */
  @PUT("post/{id}")
  fun updatePost(@Path("id") id: String, post: Post): Flow<Post>

  /**
   * return id of deleted [Post].
   */
  @DELETE("post/{id}")
  fun deletePost(@Path("id") id: String): Flow<String>
}