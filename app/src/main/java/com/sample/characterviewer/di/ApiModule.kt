package com.sample.characterviewer.di

import com.google.gson.Gson
import com.sample.characterviewer.remote.ApiDetails
import com.sample.characterviewer.remote.ApiRequest
import com.sample.characterviewer.repository.Repository
import com.sample.characterviewer.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides   //returns Gson object
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides   //returns OkHttp client
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level= HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }

    @Provides   // returns retrofit instance by taking GSON,OkHTTPClient
    fun provideRetrofit(
        gson: Gson,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASEURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Provides // returns apiRequest by taking retrofit client as input
    fun provideAPI(
        retrofit: Retrofit
    ): ApiRequest {
        return retrofit.create(ApiRequest::class.java)
    }

    @Provides   //returns repository by taking apiRequest
    fun provideRepository(apiRequest: ApiRequest): Repository {
        return RepositoryImpl(apiRequest)
    }
}