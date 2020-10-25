package com.thedesignerx.saim.humaravisa
import java.io.Serializable

data class Video(
    var url: String = "",
    var name: String = ""
) : Serializable