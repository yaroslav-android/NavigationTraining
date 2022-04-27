package team.uptech.training.navigation.utils.logs

import android.util.Log


class DebugLogger : Logger {

  override fun log(event: Event) {
    Log.d(event.name, event.message, event.exception)
  }
}