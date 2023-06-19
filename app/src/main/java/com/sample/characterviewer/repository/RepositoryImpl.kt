package com.sample.characterviewer.repository


import com.sample.characterviewer.model.CharacterViewerModel
import com.sample.characterviewer.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
): Repository{

    override suspend fun getSimpsonCharacters():CharacterViewerModel=apiRequest.getSimpsonCharacters()

    override suspend fun getWireCharacters(): CharacterViewerModel =apiRequest.getWireCharacters()
}