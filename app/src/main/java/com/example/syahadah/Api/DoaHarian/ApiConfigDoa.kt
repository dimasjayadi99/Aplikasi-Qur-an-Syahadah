package com.example.syahadah.Api.DoaHarian

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfigDoa {

    const val baseUrl = "https://tanyadoa-api.herokuapp.com/"

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiServiceDoa{
        return getRetrofit().create(ApiServiceDoa::class.java)
    }

}