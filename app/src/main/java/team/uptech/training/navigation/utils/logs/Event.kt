package team.uptech.training.navigation.utils.logs

abstract class Event(
  val name: String,
  val message: String,
  val exception: Throwable? = null
)