package team.uptech.training.navigation.di.component

import dagger.Component
import retrofit2.Retrofit
import team.uptech.training.navigation.di.module.NetworkingModule
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkingModule::class])
interface ApplicationComponent {
  fun providesRetrofit(): Retrofit
}