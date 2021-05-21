package com.nunu.simpleserverconnection.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nunu.simpleserverconnection.R
import com.nunu.simpleserverconnection.data.model.Repo
import com.nunu.simpleserverconnection.databinding.ItemRepoBinding

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    private var dataList = mutableListOf<Repo>()
    class RepoViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(repo: Repo) {
            binding.repo = repo
            binding.txtRepoStars.text = repo.stars.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemRepoBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_repo, parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun replaceList(newList: MutableList<Repo>) {
        dataList = newList.toMutableList()
        notifyDataSetChanged()
    }
}