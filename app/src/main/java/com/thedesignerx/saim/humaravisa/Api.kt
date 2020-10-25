package com.thedesignerx.saim.humaravisa

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("7ab8ba49")
    fun getContact(): Call<JsonVisa?>?

    companion object {
        const val BASE_URL: String = "https://api.mocki.io/v1/"
    }
}