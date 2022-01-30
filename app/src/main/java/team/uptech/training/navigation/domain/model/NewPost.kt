package team.uptech.training.navigation.domain.model


data class NewPost(
  val text: String,
  val image: String,
  val tags: List<String>,
  val ownerId: String
)