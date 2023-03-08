package com.example.syahadah.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.syahadah.Adapter.AdapterSurah
import com.example.syahadah.Api.QuranAudio.ApiConfigSurah
import com.example.syahadah.Model.ResponseSurahQuran
import com.example.syahadah.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AudioFragment : Fragment() {

    private var mylist = ArrayList<ResponseSurahQuran>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_audio, container, false)
        val rv_surah = view.findViewById<RecyclerView>(R.id.rv_surah)
        val pb_load = view.findViewById<ProgressBar>(R.id.pb_load)

        ApiConfigSurah.getService().getSurah().enqueue(object : Callback<ArrayList<ResponseSurahQuran>>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ArrayList<ResponseSurahQuran>>, response: Response<ArrayList<ResponseSurahQuran>>) {
                if (response.isSuccessful){
                    pb_load.visibility = View.INVISIBLE
                    val listsurah = response.body()
                    listsurah?.let { mylist.addAll(it) }
                    val setSurahAdapter = AdapterSurah(mylist)
                    rv_surah.apply {
                        layoutManager = LinearLayoutManager(view.context)
                        setHasFixedSize(true)
                        setSurahAdapter.notifyDataSetChanged()
                        adapter = setSurahAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<ResponseSurahQuran>>, t: Throwable) {
                Toast.makeText(view.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        return view
    }
}