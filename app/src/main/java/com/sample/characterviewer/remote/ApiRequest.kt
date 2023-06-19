package com.sample.characterviewer.remote

import com.sample.characterviewer.model.CharacterViewerModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.SIMPSON_ENDPOINT)
    suspend fun getSimpsonCharacters(): CharacterViewerModel

    @GET(ApiDetails.WIRE_ENDPOINT)
    suspend fun getWireCharacters(): CharacterViewerModel

}