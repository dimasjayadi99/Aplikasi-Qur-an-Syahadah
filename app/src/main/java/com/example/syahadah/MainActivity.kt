package com.example.syahadah

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.syahadah.Adapter.TablayoutAdapter
import com.example.syahadah.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tabAdapter: TablayoutAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabAdapter = TablayoutAdapter(supportFragmentManager, lifecycle)

        with(binding) {
            viewpager.adapter = tabAdapter

            TabLayoutMediator(tabLayout, viewpager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Doa Harian"
                    1 -> tab.text = "Quran Audio"
                }
            }.attach()
        }


    }
}