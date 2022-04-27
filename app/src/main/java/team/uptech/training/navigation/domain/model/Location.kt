package team.uptech.training.navigation.domain.model


data class Location(
  val street: String,
  val city: String,
  val state: String,
  val country: String,
  val timezone: String
)
