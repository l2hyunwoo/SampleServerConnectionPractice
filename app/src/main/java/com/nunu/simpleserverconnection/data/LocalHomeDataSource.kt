package com.nunu.simpleserverconnection.data

import com.nunu.simpleserverconnection.R
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

    override fun fetchGitHubItems(): MutableList<Menu> {
        TODO("Not yet implemented")
    }
}