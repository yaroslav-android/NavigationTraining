package team.uptech.training.navigation.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.*
import team.uptech.training.navigation.data.model.DataList
import team.uptech.training.navigation.data.model.NewUser
import team.uptech.training.navigation.data.model.User
import team.uptech.training.navigation.data.model.UserPreview


interface UserApi {

  @GET("user")
  fun getUsers(): Flow<DataList<UserPreview>>

  @GET("user/{id}")
  fun getUser(@Path("id") id: String): Flow<User>

  @POST("user/create")
  fun createUser(user: NewUser): Flow<User>

  /**
   * email is forbidden for update.
   */
  @PUT("user/{id}")
  fun updateUser(@Path("id") id: String, user: User): Flow<User>

  /**
   * return id of deleted [User].
   */
  @DELETE("user/{id}")
  fun deleteUser(@Path("id") id: String): Flow<String>
}