package team.uptech.training.navigation.data.repository.post.logs

import team.uptech.training.navigation.utils.logs.Event


class PostEvent(
  message: String,
  exception: Throwable
) : Event(
  name = "API_post",
  message = message,
  exception = exception
)