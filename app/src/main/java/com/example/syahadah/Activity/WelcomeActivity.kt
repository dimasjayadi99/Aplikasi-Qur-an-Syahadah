package com.example.syahadah.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.syahadah.MainActivity
import com.example.syahadah.R

class WelcomeActivity : AppCompatActivity() {

    private var timeload: Int = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Handler().postDelayed(Runnable {
            val i = Intent(this@WelcomeActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }, timeload.toLong())
    }
}