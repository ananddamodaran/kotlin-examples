package com.ananddamodaran.chapter1

import android.util.Log
import com.ananddamodaran.chapter1.data.ForeCastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by anand on 3/15/18.
 */
class ForecastRequest(val zipCode: String) {
    companion object {
        //  private val APP_ID="57235b43518963f7ee1d6fcf4c8da75e"
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"

        private val WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?" +
                "appid=$APP_ID&q="
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="


    }

    fun execute(): ForeCastResult {
        val forecastJsonString = URL(COMPLETE_URL + zipCode).readText()
        Log.d("ForecastRequest", forecastJsonString)
        return Gson().fromJson(forecastJsonString, ForeCastResult::class.java)

    }
}