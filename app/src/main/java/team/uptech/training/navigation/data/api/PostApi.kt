package team.uptech.training.navigation.data.api

import retrofit2.http.*
import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.NewPostNetwork
import team.uptech.training.navigation.data.model.PostNetwork
import team.uptech.training.navigation.data.model.PostPreviewNetwork


interface PostApi {

  @GET("post")
  suspend fun getPosts(): DataList<PostPreviewNetwork>

  @GET("user/{id}/post")
  suspend fun getPostsByUser(@Path("id") id: String): DataList<PostPreviewNetwork>

  @GET("/tag/{tag}/post")
  suspend fun getPostsByTag(@Path("tag") tag: String): DataList<PostPreviewNetwork>

  @GET("post/{id}")
  suspend fun getPost(@Path("id") id: String): PostNetwork

  @POST("post/create")
  suspend fun createPost(post: NewPostNetwork): PostNetwork

  /**
   * owner is forbidden for update.
   */
  @PUT("post/{id}")
  suspend fun updatePost(@Path("id") id: String, post: PostNetwork): PostNetwork

  /**
   * return id of deleted [PostNetwork].
   */
  @DELETE("post/{id}")
  suspend fun deletePost(@Path("id") id: String): String
}