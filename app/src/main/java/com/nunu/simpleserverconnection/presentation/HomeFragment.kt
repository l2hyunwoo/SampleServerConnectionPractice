package com.nunu.simpleserverconnection.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.nunu.simpleserverconnection.R
import com.nunu.simpleserverconnection.data.HomeDataSource
import com.nunu.simpleserverconnection.data.LocalHomeDataSource
import com.nunu.simpleserverconnection.data.RemoteHomeDataSource
import com.nunu.simpleserverconnection.databinding.FragmentHomeBinding
import com.nunu.simpleserverconnection.presentation.adapter.MenuAdapter
import com.nunu.simpleserverconnection.presentation.model.Menu

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var homeDataSource: HomeDataSource = LocalHomeDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataList = homeDataSource.fetchMenuItems()

        val menuAdapter = MenuAdapter(object : MenuAdapter.ItemClick {
            override fun onClick() {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }
        })
        val layoutManager = GridLayoutManager(requireContext(), 4)
        binding.menuMainItems.adapter = menuAdapter
        binding.menuMainItems.layoutManager = layoutManager
        menuAdapter.replaceList(dataList)
    }
}