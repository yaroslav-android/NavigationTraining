package team.uptech.training.navigation

import android.app.Application
import team.uptech.training.navigation.di.component.DaggerApplicationComponent
import team.uptech.training.navigation.di.module.NetworkingModule


class App : Application() {

  companion object {
    val applicationComponent = DaggerApplicationComponent.builder()
      .networkingModule(NetworkingModule(BuildConfig.BASE_URL))
      .build()
  }
}