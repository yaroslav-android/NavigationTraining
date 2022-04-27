package team.uptech.training.navigation.domain.model


data class NewUser(
  val title: String?,
  val firstName: String,
  val lastName: String,
  val gender: String?,
  val email: String,
  val dateOfBirth: String?,
  val phone: String?,
  val picture: String?,
  val location: Location?
)