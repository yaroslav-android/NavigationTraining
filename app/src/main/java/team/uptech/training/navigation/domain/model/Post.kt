package team.uptech.training.navigation.domain.model


data class Post(
  val id: String,
  val text: String,
  val image: String,
  val likes: Long,
  val link: String,
  val tags: List<String>,
  val publishDate: String,
  val owner: UserPreview
)