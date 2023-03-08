package com.example.syahadah.Api.QuranAudio

import com.example.syahadah.Model.ResponseSurah
import com.example.syahadah.Model.ResponseSurahQuran
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceSurah {
    @GET("surat")
    fun getSurah() : Call<ArrayList<ResponseSurahQuran>>
}