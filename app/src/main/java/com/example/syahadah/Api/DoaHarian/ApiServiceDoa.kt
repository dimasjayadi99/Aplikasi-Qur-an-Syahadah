package com.example.syahadah.Api.DoaHarian

import com.example.syahadah.Model.ResponseDoaHarian
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceDoa {
    @GET("all")
    fun getDoaHarian() : Call<ResponseDoaHarian>
}