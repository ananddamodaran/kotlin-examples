package com.ananddamodaran.memegenerator

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by anand on 3/21/18.
 */
fun EditText.afterTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(text: Editable?) {
            callback.invoke(text.toString())
        }

    })


}

fun Bitmap.saveToGallery(context: Context,title: String,onSave:(Uri)->Unit ){
  val url:String =  MediaStore.Images.Media.insertImage(context.contentResolver,this,title , "")
    onSave.invoke(Uri.parse(url))
}