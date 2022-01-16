package team.uptech.training.navigation.data.model

import com.squareup.moshi.Json


data class NewPost(
  @field:Json(name = "text")
  val text: String,
  @field:Json(name = "image")
  val image: String,
  @field:Json(name = "tags")
  val tags: List<String>,
  @field:Json(name = "owner")
  val ownerId: String
)