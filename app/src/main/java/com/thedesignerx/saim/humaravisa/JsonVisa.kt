package com.thedesignerx.saim.humaravisa
import java.io.Serializable

data class JSONRestaurant(
    var images: List<Image> = listOf(),
    var name: String = ""
):Serializable