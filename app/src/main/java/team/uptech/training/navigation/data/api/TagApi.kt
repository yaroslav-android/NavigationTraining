package team.uptech.training.navigation.data.api

import retrofit2.http.GET
import team.uptech.training.navigation.data.model.DataList


interface TagApi {

  @GET("tag")
  suspend fun getTags(): DataList<String>
}