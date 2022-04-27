package team.uptech.training.navigation.data.repository.user.logs

import team.uptech.training.navigation.utils.logs.Event


class UserEvent(
  message: String,
  exception: Throwable
) : Event(
  name = "API_user",
  message = message,
  exception = exception
)