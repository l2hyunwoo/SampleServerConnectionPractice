package com.nunu.simpleserverconnection.data

import com.nunu.simpleserverconnection.data.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}/repos")
    fun userRepos(
        @Path("username") username: String
    ): Call<List<Repo>>
}