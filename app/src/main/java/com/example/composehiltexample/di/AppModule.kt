package com.example.composehiltexample.di

import com.example.composehiltexample.core.utils.Constants.BASE_URL
import com.example.composehiltexample.data.api.CharacterApi
import com.example.composehiltexample.data.repository.CharacterRepositoryImpl
import com.example.composehiltexample.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance():Retrofit=Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterApi):CharacterRepository{
        return CharacterRepositoryImpl(api)
    }




}