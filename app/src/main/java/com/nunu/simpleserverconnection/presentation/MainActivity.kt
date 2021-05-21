package com.nunu.simpleserverconnection.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.nunu.simpleserverconnection.R
import com.nunu.simpleserverconnection.databinding.ActivityMainBinding
import com.nunu.simpleserverconnection.presentation.adapter.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setViewPagerAdapter()
        binding.bnvMain.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> binding.vpMain.currentItem = 0
                else -> binding.vpMain.currentItem = 1
            }
            true
        }
    }

    private fun setViewPagerAdapter() {
        val viewPagerAdapter = MainViewPagerAdapter(this)
        binding.vpMain.apply {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(PageChangeCallBack())
        }
    }

    private inner class PageChangeCallBack : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.bnvMain.selectedItemId = when (position) {
                0 -> R.id.home
                1 -> R.id.person
                else -> throw IllegalArgumentException("Wrong Position $position")
            }
        }
    }
}