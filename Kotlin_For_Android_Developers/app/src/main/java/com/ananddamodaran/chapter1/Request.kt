package com.ananddamodaran.chapter1

import android.util.Log
import java.net.URL

/**
 * Created by anand on 3/12/18.
 */
class Request(val url:String){
    fun  run(){
       val foreCastJsonString = URL(url).readText()
        Log.d(javaClass.simpleName, foreCastJsonString)
    }
}