package com.example.syahadah.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.syahadah.Adapter.AdapterDoa
import com.example.syahadah.Api.DoaHarian.ApiConfigDoa
import com.example.syahadah.Model.ResponseDoaHarian
import com.example.syahadah.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DoaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_doa, container, false)
        val rv_doa = view.findViewById<RecyclerView>(R.id.rv_doa)
        val sv_doa = view.findViewById<SearchView>(R.id.sv_doa)
        val pb_load = view.findViewById<ProgressBar>(R.id.pb_load)

        ApiConfigDoa.getService().getDoaHarian().enqueue(object : Callback<ResponseDoaHarian> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<ResponseDoaHarian>,
                response: Response<ResponseDoaHarian>
            ) {
                if (response.isSuccessful) {
                    pb_load.visibility = View.INVISIBLE
                    val responsebody = response.body()
                    val responselist = responsebody?.data
                    val setDoaAdapter = AdapterDoa(responselist)
                    rv_doa.apply {
                        layoutManager = LinearLayoutManager(view.context)
                        setHasFixedSize(true)
                        setDoaAdapter.notifyDataSetChanged()
                        adapter = setDoaAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDoaHarian>, t: Throwable) {
                Toast.makeText(view.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
        return view
    }
}