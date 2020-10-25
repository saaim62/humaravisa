package com.thedesignerx.saim.humaravisa
import java.io.Serializable

data class JsonVisa(
    var images: List<Image> = listOf(),
    var videos: List<Video> = listOf(),
    var name: String
):Serializable

data class Image(
    var url: String = "",
    var name: String = ""
) : Serializable

data class Video(
    var url: String = "",
    var name: String = ""
) : Serializable