package com.ananddamodaran.githubclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ananddamodaran.githubclient.model.Repository
import com.ananddamodaran.githubclient.network.GitHubApi
import com.ananddamodaran.githubclient.view.Detail
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val adapter = Adapter({repository ->
       val intent = Detail.getInent(this,repository.name,repository.url)
        startActivity(intent)

    })

    val gitHubApi: GitHubApi
    private var job: Job = Job()

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create()).build()
        gitHubApi = retrofit.create(GitHubApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search_view.onTextChanged { text ->
            searchGitHub(text)
        }
        recycler_view.adapter = adapter


    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    fun searchGitHub(query: String) {
        adapter.setRepositories(emptyList())
        progress.visibility = View.VISIBLE
        job.cancel()
        job = launch(UI) {
            try {
                val repos = downloadRepositoriesList(query)
                adapter.setRepositories(repos)
                progress.visibility = View.GONE
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }

    }

    suspend fun downloadRepositoriesList(query: String): Collection<Repository> = kotlinx.coroutines.experimental.run(CommonPool) {
        val body = gitHubApi.searchRepositories(query).execute().body()
        if (body != null) {
            return@run body.repositories
        } else {
            return@run emptyList<Repository>()
        }
    }
}

