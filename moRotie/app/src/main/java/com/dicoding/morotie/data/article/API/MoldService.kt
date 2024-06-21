package com.dicoding.morotie.api

import retrofit2.Call
import retrofit2.http.GET

interface MoldService {
    @GET("/")
    fun getMoldItems(): Call<MoldResponse>
}
