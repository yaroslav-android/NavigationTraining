package team.uptech.training.navigation.di.module

import dagger.Module
import dagger.Provides
import team.uptech.training.navigation.BuildConfig
import team.uptech.training.navigation.utils.logs.DebugLogger
import team.uptech.training.navigation.utils.logs.Logger
import team.uptech.training.navigation.utils.logs.ProdLogger
import javax.inject.Singleton


@Module
class UtilsModule {

  @Singleton
  @Provides
  fun provideLogger(): Logger {
    return if (BuildConfig.DEBUG) {
      DebugLogger()
    } else {
      ProdLogger()
    }
  }
}