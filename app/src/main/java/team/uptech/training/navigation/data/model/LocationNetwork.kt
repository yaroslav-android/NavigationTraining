package team.uptech.training.navigation.data.model

import com.squareup.moshi.Json


data class LocationNetwork(
  @field:Json(name = "street")
  val street: String?,
  @field:Json(name = "city")
  val city: String?,
  @field:Json(name = "state")
  val state: String?,
  @field:Json(name = "country")
  val country: String?,
  @field:Json(name = "timezone")
  val timezone: String?
)
