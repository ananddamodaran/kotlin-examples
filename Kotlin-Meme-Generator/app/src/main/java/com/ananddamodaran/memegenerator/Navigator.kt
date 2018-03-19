package com.ananddamodaran.memegenerator

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by anand on 3/19/18.
 */
class Navigator {
    companion object {
        fun redirectToMemeComposerScreen(activity: Context, imageUrl: Uri?){
            val intent = Intent(activity,MemeComposerActivity::class.java)
            intent.putExtra(MemeComposerActivity.Constants.EXTRA_IMAGE, imageUrl)
            activity.startActivity(intent)

        }
    }
}