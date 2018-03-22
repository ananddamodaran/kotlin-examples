package com.ananddamodaran.githubclient.network

import com.ananddamodaran.githubclient.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by anand on 3/22/18.
 */
interface GitHubApi {
    @GET("/search/repositories")
    fun searchRepositories(@Query("q")query:String) : Call<RepositoryResponse>
}