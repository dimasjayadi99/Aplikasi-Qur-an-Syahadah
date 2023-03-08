package com.example.syahadah.Api.QuranAudio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfigSurah {
    const val baseUrl = "https://equran.id/api/"

    fun getRetorfit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiServiceSurah{
        return getRetorfit().create(ApiServiceSurah::class.java)
    }
}