package team.uptech.training.navigation.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import team.uptech.training.navigation.BuildConfig
import javax.inject.Singleton


@Module
class NetworkingModule(private val url: String) {

  @Singleton
  @Provides
  fun provideClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor { chain ->
        val request = chain.request()
          .newBuilder()
          .apply {
            addHeader("app-id", BuildConfig.API_KEY)
          }.build()

        chain.proceed(request)
      }.build()
  }

  @Singleton
  @Provides
  fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(client)
      .baseUrl(url)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }
}