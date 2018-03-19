package com.ananddamodaran.memegenerator

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by anand on 3/19/18.
 */
class MemeComposerActivity : AppCompatActivity(){
    object Constants{
        val EXTRA_IMAGE = "extra_img"
    }
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}