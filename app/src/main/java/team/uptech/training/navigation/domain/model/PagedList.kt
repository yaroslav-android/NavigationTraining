package team.uptech.training.navigation.domain.model


data class PagedList<T>(
  val data: List<T>,
  val total: Int,
  val page: Int,
  val limit: Int
)