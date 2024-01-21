package com.prima.promoapp.di

import com.prima.promoapp.data.data_sources.remote.PromoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAuthInterceptorOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(PromoApi.API_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providePromoApi(
        retrofit: Retrofit
    ): PromoApi.Service {
        return retrofit.create(PromoApi.Service::class.java)
    }

}