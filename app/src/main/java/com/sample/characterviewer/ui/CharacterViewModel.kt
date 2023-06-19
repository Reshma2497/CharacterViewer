package com.sample.characterviewer.ui

import androidx.lifecycle.ViewModel
import com.sample.characterviewer.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sample.characterviewer.model.CharacterViewerModel
import android.content.Context
import com.sample.characterviewer.R
import kotlinx.coroutines.launch


@HiltViewModel
class CharacterViewModel @Inject constructor(
    val repository: Repository
):ViewModel() {

    val character = MutableLiveData<CharacterViewerModel>()

    fun getCharacters(context: Context) {
        viewModelScope.launch {
            val result = when (val appType = context.getString(R.string.app_type)) {
                "simpsons" -> repository.getSimpsonCharacters()
                "wire" -> repository.getWireCharacters()
                else -> throw IllegalArgumentException("Invalid appType: $appType")
            }
            character.postValue(result)

        }

    }
}