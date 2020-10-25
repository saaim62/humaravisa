package com.thedesignerx.saim.humaravisa
import java.io.Serializable

data class Image(
    var url: String = "",
    var name: String = ""
) : Serializable