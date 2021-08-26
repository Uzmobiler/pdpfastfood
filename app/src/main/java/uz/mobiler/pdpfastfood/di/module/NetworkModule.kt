package uz.mobiler.pdpfastfood.di.module

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.mobiler.pdpfastfood.network.AuthService
import uz.mobiler.pdpfastfood.network.RegionService
import uz.mobiler.pdpfastfood.utils.NetworkHelper
import javax.inject.Singleton

@Module
class NetworkModule(var context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideBaseUrl() = "https://spring.pdp.uz/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideGsonConvertor(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit) = retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun provideRegionService(retrofit: Retrofit) = retrofit.create(RegionService::class.java)


}