package com.thedesignerx.saim.humaravisa

import com.thedesignerx.saim.humaravisa.Image
import java.io.Serializable

data class JSONRestaurant(
    var images: List<Image> = listOf(),
    var name: String = ""
):Serializable