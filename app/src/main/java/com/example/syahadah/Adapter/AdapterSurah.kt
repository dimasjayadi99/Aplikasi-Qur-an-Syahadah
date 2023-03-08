package com.example.syahadah.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.syahadah.Activity.DetailSurahActivity
import com.example.syahadah.MainActivity
import com.example.syahadah.Model.ResponseSurahQuran
import com.example.syahadah.R

class AdapterSurah(val Datasurah: ArrayList<ResponseSurahQuran>) :
    RecyclerView.Adapter<AdapterSurah.MyViewHolder>() {
    var mediaPlayer: MediaPlayer? = null

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.findViewById<TextView>(R.id.nama)
        val asma = view.findViewById<TextView>(R.id.asma)
        val arti = view.findViewById<TextView>(R.id.arti)
        val type = view.findViewById<TextView>(R.id.type)
        val card = view.findViewById<CardView>(R.id.list_item)
//        val play = view.findViewById<Button>(R.id.play)
//        val pause = view.findViewById<Button>(R.id.pause)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_surah, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nama.text = "" + Datasurah[position].nomor + ". " + Datasurah[position].namaLatin
        holder.asma.text = Datasurah[position].nama
        holder.arti.text = "Arti Surah : " + Datasurah[position].arti
        holder.type.text = "Type Surah : " + Datasurah[position].tempatTurun

        holder.card.setOnClickListener {
            val intent = Intent(it.context, DetailSurahActivity::class.java)
            intent.putExtra("nomor", Datasurah[position].nomor)
            intent.putExtra("nama", Datasurah[position].namaLatin)
            intent.putExtra("asma", Datasurah[position].nama)
            intent.putExtra("arti", Datasurah[position].arti)
            intent.putExtra("type", Datasurah[position].tempatTurun)
            intent.putExtra("jmlh", Datasurah[position].jumlahAyat)
            intent.putExtra("deskripsi", Datasurah[position].deskripsi)
            intent.putExtra("audio", Datasurah[position].audio)
            it.context.startActivity(intent)
        }

//        holder.play.setOnClickListener{
//            val urlAudio = Datasurah[position].audio
//            mediaPlayer = MediaPlayer()
//            mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
//            mediaPlayer!!.setDataSource(urlAudio)
//            mediaPlayer!!.prepare()
//            mediaPlayer!!.start()
//        }
//
//        holder.pause.setOnClickListener{
//            if (mediaPlayer!!.isPlaying){
//                mediaPlayer!!.stop()
//                mediaPlayer!!.reset()
//                mediaPlayer!!.release()
//            }
//            else{
//                Toast.makeText(it.context, "Audio has been stop", Toast.LENGTH_SHORT).show()
//            }
//        }

    }

    override fun getItemCount(): Int {
        if (Datasurah != null) {
            return Datasurah.size
        }
        return 0
    }
}