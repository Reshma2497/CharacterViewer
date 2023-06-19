package com.sample.characterviewer.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RelatedTopicModel(
    @SerializedName("FirstURL")
    val firstURL: String? = "",
    @SerializedName("Icon")
    val icon: IconModel? = IconModel(),
    @SerializedName("Result")
    val result: String? = "",
    @SerializedName("Text")
    val text: String? = ""
) : Serializable