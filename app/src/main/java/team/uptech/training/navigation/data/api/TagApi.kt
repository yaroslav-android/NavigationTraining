package team.uptech.training.navigation.data.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import team.uptech.training.navigation.data.model.DataList


interface TagApi {

  @GET("tag")
  fun getTags(): Flow<DataList<String>>
}