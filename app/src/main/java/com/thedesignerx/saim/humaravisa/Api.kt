package com.thedesignerx.saim.humaravisa

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("6142")
    fun getContact(): Call<JSONRestaurant?>?

    companion object {
        const val BASE_URL: String = "https://api.staging.seatedapp.io/v1/business/"
    }
}