package team.uptech.training.navigation.data.api

import retrofit2.http.*
import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.NewUser
import team.uptech.training.navigation.data.model.User
import team.uptech.training.navigation.data.model.UserPreview


interface UserApi {

  @GET("user")
  suspend fun getUsers(): DataList<UserPreview>

  @GET("user/{id}")
  suspend fun getUser(@Path("id") id: String): User

  @POST("user/create")
  suspend fun createUser(user: NewUser): User

  /**
   * email is forbidden for update.
   */
  @PUT("user/{id}")
  suspend fun updateUser(@Path("id") id: String, user: User): User

  /**
   * return id of deleted [User].
   */
  @DELETE("user/{id}")
  suspend fun deleteUser(@Path("id") id: String): String
}