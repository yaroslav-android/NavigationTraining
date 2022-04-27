package team.uptech.training.navigation.data.api

import retrofit2.http.*
import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.NewUserNetwork
import team.uptech.training.navigation.data.model.UserNetwork
import team.uptech.training.navigation.data.model.UserPreviewNetwork


interface UserApi {

  @GET("user")
  suspend fun getUsers(): DataList<UserPreviewNetwork>

  @GET("user/{id}")
  suspend fun getUser(@Path("id") id: String): UserNetwork

  @POST("user/create")
  suspend fun createUser(user: NewUserNetwork): UserNetwork

  /**
   * email is forbidden for update.
   */
  @PUT("user/{id}")
  suspend fun updateUser(@Path("id") id: String, user: UserNetwork): UserNetwork

  /**
   * return id of deleted [UserNetwork].
   */
  @DELETE("user/{id}")
  suspend fun deleteUser(@Path("id") id: String): String
}