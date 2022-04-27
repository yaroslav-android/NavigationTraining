package team.uptech.training.navigation.data.repository.tag.logs

import team.uptech.training.navigation.utils.logs.Event


class TagEvent(
  message: String,
  exception: Throwable
) : Event(
  name = "API_tag",
  message = message,
  exception = exception
)