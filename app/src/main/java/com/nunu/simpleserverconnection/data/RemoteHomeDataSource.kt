package com.nunu.simpleserverconnection.data

import com.nunu.simpleserverconnection.R
import com.nunu.simpleserverconnection.data.model.Repo
import com.nunu.simpleserverconnection.presentation.adapter.RepoAdapter
import com.nunu.simpleserverconnection.presentation.model.Menu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteHomeDataSource(
    private val repoAdapter: RepoAdapter
) : HomeDataSource {
    override fun fetchMenuItems(): MutableList<Menu> {
        return mutableListOf<Menu>(
            Menu(
                imgMenu = R.drawable.ic_home,
                title = "누누"
            ),
            Menu(
                imgMenu = R.drawable.ic_home,
                title = "누누"
            ),
            Menu(
                imgMenu = R.drawable.ic_home,
                title = "누누"
            ),
            Menu(
                imgMenu = R.drawable.ic_home,
                title = "누누"
            ),
            Menu(
                imgMenu = R.drawable.ic_home,
                title = "누누"
            ),
            Menu(
                imgMenu = R.drawable.ic_home,
                title = "누누"
            )
        )
    }

    override fun fetchGitHubItems(): MutableList<Repo> {
        val response = RetrofitObject.GITHUB_SERVICE.userRepos("l2hyunwoo")
        response.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                if (response.isSuccessful) {
                    repoAdapter.replaceList(requireNotNull(response.body()).toMutableList())
                }
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return mutableListOf(Repo("", "", 3))
    }
}