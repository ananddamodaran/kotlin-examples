package com.ananddamodaran.githubclient

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by anand on 3/22/18.
 */
fun EditText.onTextChanged(callback: (String) -> Unit){
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

                callback.invoke(text.toString())


        }

    })
}