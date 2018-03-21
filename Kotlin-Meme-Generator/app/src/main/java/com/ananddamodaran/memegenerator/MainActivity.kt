package com.ananddamodaran.memegenerator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.ananddamodaran.memegenerator.MainActivity.Constant.CODE_IMAGE_PIC

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    object Constant {
        val CODE_IMAGE_PIC = 1500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.create_meme_btn).setOnClickListener { launchPicturesIntent() }
    }

    private fun launchPicturesIntent() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Meme Picture"), CODE_IMAGE_PIC)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Toast.makeText(this, "call", Toast.LENGTH_SHORT).show()

        if (requestCode == CODE_IMAGE_PIC && resultCode == RESULT_OK) {
            Toast.makeText(this, "result", Toast.LENGTH_SHORT).show()
            var uri = data?.data
            Toast.makeText(this, "uri: ${uri.toString()}", Toast.LENGTH_SHORT).show()
            Log.d(TAG, uri.toString())
            Navigator.redirectToMemeComposerScreen(this, uri)

        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}
