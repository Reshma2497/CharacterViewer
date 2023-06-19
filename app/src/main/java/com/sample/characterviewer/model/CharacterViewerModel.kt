package com.sample.characterviewer.model


import com.google.gson.annotations.SerializedName

data class CharacterViewerModel(
    @SerializedName("Abstract")
    val `abstract`: String? = "",
    @SerializedName("AbstractSource")
    val abstractSource: String? = "",
    @SerializedName("AbstractText")
    val abstractText: String? = "",
    @SerializedName("AbstractURL")
    val abstractURL: String? = "",
    @SerializedName("Answer")
    val answer: String? = "",
    @SerializedName("AnswerType")
    val answerType: String? = "",
    @SerializedName("Definition")
    val definition: String? = "",
    @SerializedName("DefinitionSource")
    val definitionSource: String? = "",
    @SerializedName("DefinitionURL")
    val definitionURL: String? = "",
    @SerializedName("Entity")
    val entity: String? = "",
    @SerializedName("Heading")
    val heading: String? = "",
    @SerializedName("Image")
    val image: String? = "",
    @SerializedName("ImageHeight")
    val imageHeight: Int? = 0,
    @SerializedName("ImageIsLogo")
    val imageIsLogo: Int? = 0,
    @SerializedName("ImageWidth")
    val imageWidth: Int? = 0,
    @SerializedName("Infobox")
    val infobox: String? = "",
    @SerializedName("meta")
    val meta: MetaModel? = MetaModel(),
    @SerializedName("Redirect")
    val redirect: String? = "",
    @SerializedName("RelatedTopics")
    val relatedTopics: List<RelatedTopicModel?>? = listOf(),
    @SerializedName("Results")
    val results: List<String?>? = listOf(),
    @SerializedName("Type")
    val type: String? = ""
)