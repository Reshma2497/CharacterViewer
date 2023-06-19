package com.sample.characterviewer.repository

import com.sample.characterviewer.model.CharacterViewerModel

interface Repository {

    suspend fun getSimpsonCharacters(): CharacterViewerModel

    suspend fun getWireCharacters(): CharacterViewerModel
}