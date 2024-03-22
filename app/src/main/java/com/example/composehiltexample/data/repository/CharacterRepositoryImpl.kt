package com.example.composehiltexample.data.repository

import com.example.composehiltexample.core.common.Resource
import com.example.composehiltexample.data.api.CharacterApi
import com.example.composehiltexample.data.mapper.toDomainCharacter
import com.example.composehiltexample.domain.model.Characters
import com.example.composehiltexample.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi): CharacterRepository {
    override fun getAllCharacters(): Flow<Resource<List<Characters>>> =flow{
        emit(Resource.Loading())

        val result= characterApi.getAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(result))
    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }


}