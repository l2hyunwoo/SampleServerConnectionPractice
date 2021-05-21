package com.nunu.simpleserverconnection.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nunu.simpleserverconnection.presentation.HomeFragment
import com.nunu.simpleserverconnection.presentation.PersonalInfoFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            else -> PersonalInfoFragment()
        }
    }
}