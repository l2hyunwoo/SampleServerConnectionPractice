package com.nunu.simpleserverconnection.data

import com.nunu.simpleserverconnection.R
import com.nunu.simpleserverconnection.data.model.Repo
import com.nunu.simpleserverconnection.presentation.model.Menu

class LocalHomeDataSource : HomeDataSource {
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
        return mutableListOf(
            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),
            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),            Repo(
                name = "누누",
                description = "안녕앙녕",
                stars = 3
            ),
        )

    }
}