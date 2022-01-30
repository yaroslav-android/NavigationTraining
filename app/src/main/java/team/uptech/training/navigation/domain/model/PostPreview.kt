package team.uptech.training.navigation.domain.model


data class PostPreview(
  val id: String,
  val text: String,
  val image: String,
  val likes: Long,
  val tags: List<String>,
  val publishDate: String,
  val owner: UserPreview
)