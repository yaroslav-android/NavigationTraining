package team.uptech.training.navigation.data.api

import retrofit2.http.*
import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.NewPost
import team.uptech.training.navigation.data.model.Post
import team.uptech.training.navigation.data.model.PostPreview


interface PostApi {

  @GET("post")
 suspend fun getPosts(): DataList<PostPreview>

  @GET("user/{id}/post")
  suspend fun getPostsByUser(@Path("id") id: String): DataList<PostPreview>

  @GET("user/{id}/tag")
  suspend fun getPostsByTag(@Path("tag") tag: String): DataList<PostPreview>

  @GET("post/{id}")
  suspend fun getPost(@Path("id") id: String): Post

  @POST("post/create")
  suspend fun createPost(post: NewPost): Post

  /**
   * owner is forbidden for update.
   */
  @PUT("post/{id}")
  suspend fun updatePost(@Path("id") id: String, post: Post): Post

  /**
   * return id of deleted [Post].
   */
  @DELETE("post/{id}")
  suspend fun deletePost(@Path("id") id: String): String
}