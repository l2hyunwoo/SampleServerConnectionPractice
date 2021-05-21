package com.nunu.simpleserverconnection.presentation.adapter

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nunu.simpleserverconnection.R
import com.nunu.simpleserverconnection.databinding.ItemMenuBinding
import com.nunu.simpleserverconnection.presentation.model.Menu

class MenuAdapter(
    private val itemClick: ItemClick
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private var dataList = mutableListOf<Menu>()

    inner class MenuViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(menu: Menu) {
            binding.menu = menu
            val textTitle = SpannableStringBuilder(menu.title)
            textTitle.setSpan(
                UnderlineSpan(),
                0,
                menu.title.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
            )
            binding.txtMenuTitle.setText(textTitle)
            binding.root.setOnClickListener { itemClick.onClick() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMenuBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_menu, parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun replaceList(newList: MutableList<Menu>) {
        dataList = newList.toMutableList()
        notifyDataSetChanged()
    }

    interface ItemClick {
        fun onClick()
    }
}