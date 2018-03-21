package com.ananddamodaran.memegenerator

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

/**
 * Created by anand on 3/19/18.
 */
class Navigator {

    companion object {
        val TAG = "Navigator"
        fun redirectToMemeComposerScreen(activity: Context, imageUrl: Uri?) {
            Log.d(TAG, "redirectToMemeComposerScreen")
            val intent = Intent(activity, MemeComposerActivity::class.java)
            intent.putExtra(MemeComposerActivity.Constants.EXTRA_IMAGE, imageUrl)
            activity.startActivity(intent)

        }

        fun redirectToMemeResult(activity: Context,memeUrl:Uri) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = memeUrl
            activity.startActivity(intent)
        }
    }
}