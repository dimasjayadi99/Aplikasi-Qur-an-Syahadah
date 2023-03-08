package com.example.syahadah.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.syahadah.MainActivity
import com.example.syahadah.R
import java.util.*

class DetailSurahActivity : AppCompatActivity() {

    lateinit var txt_namaLAtin: TextView
    lateinit var txt_arti: TextView
    lateinit var txt_jumlah: TextView
    lateinit var txt_nama: TextView
    lateinit var txt_tempatTurun: TextView
    lateinit var txt_desc : TextView
    lateinit var btn_play: Button
    lateinit var btn_pause: Button
    lateinit var ic_back: ImageView
    lateinit var cardv: CardView

    var namaLatin = ""
    var nama = ""
    var arti = ""
    var jumlah = ""
    var tempatTurun = ""
    var deskripsi = ""
    var audio = ""

    private var pause: Boolean = false

    private var mediaPlayer: MediaPlayer? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_surah)

        cardv = findViewById(R.id.cardv)
        cardv.setBackgroundResource(R.drawable.bannerdetail)

        txt_namaLAtin = findViewById(R.id.txt_namaLatin)
        txt_arti = findViewById(R.id.txt_arti)
        txt_jumlah = findViewById(R.id.txt_jumlahAyat)
        txt_nama = findViewById(R.id.txt_nama)
        txt_tempatTurun = findViewById(R.id.txt_tempatTurun)
        txt_desc = findViewById(R.id.txt_desc)

        ic_back = findViewById(R.id.ic_back)

        ic_back.setOnClickListener()
        {
            onBackPressed()
            pause = true
        }

        btn_play = findViewById(R.id.btn_play)
        btn_pause = findViewById(R.id.btn_pause)
        btn_pause.isEnabled = false

        namaLatin = intent.getStringExtra("nama").toString()
        nama = intent.getStringExtra("asma").toString()
        arti = intent.getStringExtra("arti").toString()
        jumlah = intent.getIntExtra("jmlh", 0).toString()
        tempatTurun = intent.getStringExtra("type").toString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        audio = intent.getStringExtra("audio").toString()
        deskripsi = intent.getStringExtra("deskripsi").toString()

        btn_play.setOnClickListener {
            if (pause) {
                mediaPlayer!!.start()
                pause = false
                btn_play.isEnabled = false
                btn_pause.isEnabled = true
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()
            } else {
                btn_play.isEnabled = false
                btn_pause.isEnabled = true
                mediaPlayer = MediaPlayer()
                mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
                mediaPlayer!!.setDataSource(audio)
                mediaPlayer!!.prepare()
                mediaPlayer!!.start()
                Toast.makeText(this, "media playing", Toast.LENGTH_SHORT).show()
            }

            mediaPlayer!!.setOnCompletionListener {
                btn_play.isEnabled = true
                btn_pause.isEnabled = false
//                stopBtn.isEnabled = false
                Toast.makeText(applicationContext, "end", Toast.LENGTH_SHORT).show()
            }
        }

        btn_pause.setOnClickListener {
            if (mediaPlayer!!.isPlaying) {
                mediaPlayer!!.pause()
                pause = true
                btn_play.isEnabled = true
                btn_pause.isEnabled = false
//                stopBtn.isEnabled = true
                Toast.makeText(this, "media pause", Toast.LENGTH_SHORT).show()
            }
        }

        txt_namaLAtin.text = namaLatin
        txt_nama.text = nama
        txt_arti.text = " Arti Surah : " + arti
        txt_jumlah.text = "Jumlah Ayat : " + jumlah
        txt_tempatTurun.text = "Type Surah : " + tempatTurun
        txt_desc.text = deskripsi
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}