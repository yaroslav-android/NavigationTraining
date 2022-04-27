package team.uptech.training.navigation.di.component

import dagger.Component
import retrofit2.Retrofit
import team.uptech.training.navigation.di.module.NetworkingModule
import team.uptech.training.navigation.di.module.UtilsModule
import team.uptech.training.navigation.utils.logs.Logger
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkingModule::class, UtilsModule::class])
interface ApplicationComponent {
  fun providesRetrofit(): Retrofit
  fun providesLogger(): Logger
}