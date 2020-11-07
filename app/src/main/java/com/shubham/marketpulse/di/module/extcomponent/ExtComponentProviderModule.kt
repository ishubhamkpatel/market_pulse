package com.shubham.marketpulse.di.module.extcomponent

import android.content.Context
import com.google.gson.Gson
import com.shubham.marketpulse.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module
class ExtComponentProviderModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    internal fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            writeTimeout(20.toLong(), TimeUnit.SECONDS)
            readTimeout(20.toLong(), TimeUnit.SECONDS)
            connectTimeout(20.toLong(), TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            }
            cache(cache)
        }.build()
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    @Singleton
    internal fun provideCache(context: Context): Cache {
        val cacheSize = 5 * 1024 * 1024 // 5 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }
}