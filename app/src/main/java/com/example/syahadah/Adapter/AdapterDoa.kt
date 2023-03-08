package com.example.syahadah.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.syahadah.Model.DataItem
import com.example.syahadah.Model.ResponseDoaHarian
import com.example.syahadah.Model.ResponseSurahQuran
import com.example.syahadah.R

class AdapterDoa(val listDoa: List<DataItem?>?) : RecyclerView.Adapter<AdapterDoa.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nomor = view.findViewById<TextView>(R.id.txt_nomor)
        var nama = view.findViewById<TextView>(R.id.txt_nama)
        var lafal = view.findViewById<TextView>(R.id.txt_lafal)
        var transliterasi = view.findViewById<TextView>(R.id.txt_transliterasi)
        var arti = view.findViewById<TextView>(R.id.txt_arti)
        var riwayat = view.findViewById<TextView>(R.id.txt_riwayat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDoa.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doa_harian, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterDoa.ViewHolder, position: Int) {
        holder.nomor.text = listDoa?.get(position)?.idDoa
        holder.nama.text = listDoa?.get(position)?.nama
        holder.lafal.text = listDoa?.get(position)?.lafal
        holder.transliterasi.text = listDoa?.get(position)?.transliterasi
        holder.arti.text = listDoa?.get(position)?.arti
        holder.riwayat.text = listDoa?.get(position)?.riwayat
    }

    override fun getItemCount(): Int {
        if (listDoa != null) {
            return listDoa.size
        }
        return 0
    }

}