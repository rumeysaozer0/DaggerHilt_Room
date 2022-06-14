package com.rumeysaozer.roomdaggerhilt.di

import android.app.Application
import androidx.room.Room
import com.rumeysaozer.roomdaggerhilt.service.ImageApi
import com.rumeysaozer.roomdaggerhilt.service.NameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(ImageApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Provides
    @Singleton
    fun provideImageApi(retrofit: Retrofit):ImageApi =
        retrofit.create(ImageApi::class.java)
    @Provides
    @Singleton
    fun provideDatabase(app: Application): NameDatabase =
        Room.databaseBuilder(app,NameDatabase::class.java,"namedatabase")
            .build()
}