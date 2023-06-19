package com.sample.characterviewer.model


import com.google.gson.annotations.SerializedName

data class MetaModel(
    @SerializedName("attribution")
    val attribution: String?="" ,
    @SerializedName("blockgroup")
    val blockgroup: String?="",
    @SerializedName("created_date")
    val createdDate: String?="",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("designer")
    val designer:String?="",
    @SerializedName("dev_date")
    val devDate: String?="",
    @SerializedName("dev_milestone")
    val devMilestone: String? = "",
    @SerializedName("developer")
    val developer: List<DeveloperModel?>? = listOf(),
    @SerializedName("example_query")
    val exampleQuery: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_stackexchange")
    val isStackexchange: String?="",
    @SerializedName("js_callback_name")
    val jsCallbackName: String? = "",
    @SerializedName("live_date")
    val liveDate: String?="",
    @SerializedName("maintainer")
    val maintainer: MaintainerModel? = MaintainerModel(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("perl_module")
    val perlModule: String? = "",
    @SerializedName("producer")
    val producer: String?="",
    @SerializedName("production_state")
    val productionState: String? = "",
    @SerializedName("repo")
    val repo: String? = "",
    @SerializedName("signal_from")
    val signalFrom: String? = "",
    @SerializedName("src_domain")
    val srcDomain: String? = "",
    @SerializedName("src_id")
    val srcId: Int? = 0,
    @SerializedName("src_name")
    val srcName: String? = "",
    @SerializedName("src_options")
    val srcOptions: SrcOptionsModel? = SrcOptionsModel(),
    @SerializedName("src_url")
    val srcUrl: String?="",
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("tab")
    val tab: String? = "",
    @SerializedName("topic")
    val topic: List<String?>? = listOf(),
    @SerializedName("unsafe")
    val unsafe: Int? = 0
)