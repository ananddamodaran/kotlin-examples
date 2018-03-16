package com.ananddamodaran.chapter1

import com.ananddamodaran.chapter1.data.ForeCastResult
import com.google.gson.Gson
import java.net.URL

/**
 * Created by anand on 3/15/18.
 */
class ForecastRequest(val zipCode: String){
    companion object {
        private val APP_ID="57235b43518963f7ee1d6fcf4c8da75e"
        private val WEATHER_URL="http://api.openweathermap.org/data/2.5/weather?" +
                "appid=$APP_ID&q="
    }
    fun execute():ForeCastResult{
        val forecastJsonString = URL(WEATHER_URL+zipCode).readText()
        return Gson().fromJson(forecastJsonString,ForeCastResult::class.java)

    }
}