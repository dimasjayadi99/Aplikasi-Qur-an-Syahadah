package com.example.syahadah.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.syahadah.Fragment.AudioFragment
import com.example.syahadah.Fragment.DoaFragment

class TablayoutAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when(position){
            0 -> fragment = DoaFragment()
            1 -> fragment = AudioFragment()
        }
        return fragment
    }
}