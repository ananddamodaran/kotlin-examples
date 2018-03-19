package com.ananddamodaran.memegenerator

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ananddamodaran.memegenerator.MainActivity.Constant.CODE_IMAGE_PIC

class MainActivity : AppCompatActivity() {

    object Constant{
        val CODE_IMAGE_PIC =1500
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.create_meme_btn).setOnClickListener{ launchPicturesIntent() }
    }

    private fun launchPicturesIntent() {
        val intent = Intent ()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Meme Picture"),CODE_IMAGE_PIC)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == CODE_IMAGE_PIC && resultCode == Activity.RESULT_OK){
            var uri = data?.data
            Navigator.redirectToMemeComposerScreen(this,uri)

        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}
