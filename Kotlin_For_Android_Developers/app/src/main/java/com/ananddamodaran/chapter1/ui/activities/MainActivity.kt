package com.ananddamodaran.chapter1.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.ananddamodaran.chapter1.adapters.ForecastListAdapter
import com.ananddamodaran.chapter1.R
import com.ananddamodaran.chapter1.Request
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 12/03 - Sunny - 31/17",
            "Tue 13/03 - Foggy - 21/8",
            "Wed 14/03 - Cloudy - 22/17",
            "Thurs 15/03 - Rainy - 18/11",
            "Fri 16/03 - Foggy - 21/11",
            "Sat 17/03 - Trappped in Weatherstation - 23/18",
            "Sun 18/03 - Sunny - 20/07"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)
        forecast_list.adapter = ForecastListAdapter(items)
       // 4290c0294125ca0474042c04e0001b3b
        val url = "http://api.openweathermap.org/data/2.5/weather?" +
                "appid=57235b43518963f7ee1d6fcf4c8da75e&q=London,uk&mode=json&units=metric&cnt=7"
       /* val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"*/

        doAsync {
            Request(url).run()
            Log.d(javaClass.simpleName, "request started")
           uiThread { toast("request started") }
        }
    }
}
