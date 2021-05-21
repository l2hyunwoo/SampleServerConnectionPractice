package com.nunu.simpleserverconnection.data

import com.nunu.simpleserverconnection.data.model.Repo
import com.nunu.simpleserverconnection.presentation.model.Menu

interface HomeDataSource {
    fun fetchMenuItems(): MutableList<Menu>
    fun fetchGitHubItems(): MutableList<Repo>
}