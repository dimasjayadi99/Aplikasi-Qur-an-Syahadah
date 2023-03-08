package com.example.syahadah.Model

import com.google.gson.annotations.SerializedName

data class ResponseDoaHarian(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class DataItem(

	@field:SerializedName("keterangan")
	val keterangan: Any? = null,

	@field:SerializedName("kata_kunci")
	val kataKunci: List<String?>? = null,

	@field:SerializedName("lafal")
	val lafal: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("riwayat")
	val riwayat: String? = null,

	@field:SerializedName("id_doa")
	val idDoa: String? = null,

	@field:SerializedName("transliterasi")
	val transliterasi: String? = null,

	@field:SerializedName("arti")
	val arti: String? = null
)
