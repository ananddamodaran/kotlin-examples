package com.ananddamodaran.githubclient.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ananddamodaran.githubclient.R
import kotlinx.android.synthetic.main.github_detail.*

/**
 * Created by anand on 4/4/18.
 */
class  Detail : AppCompatActivity(){

    companion object {
        val KEY_URL = "url"
        val KEY_TITLE = "title"

        fun getInent(activity: Activity, title: String?,url : String? ): Intent {
            val intent = Intent(activity,Detail::class.java)
            intent.putExtra(KEY_TITLE,title)
            intent.putExtra(KEY_URL,url)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.github_detail)
        setSupportActionBar(tool_bar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = intent.extras.getString(KEY_TITLE)
        web_view.loadUrl(intent.getStringExtra(KEY_URL))


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let { if(item.itemId == android.R.id.home)finish() }
        return super.onOptionsItemSelected(item)

    }
}