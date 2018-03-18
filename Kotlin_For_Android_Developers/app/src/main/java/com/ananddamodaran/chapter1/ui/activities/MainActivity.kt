package com.ananddamodaran.chapter1.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ananddamodaran.chapter1.R
import com.ananddamodaran.chapter1.adapters.ForecastListAdapter
import com.ananddamodaran.chapter1.domain.commands.RequestForcastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
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

        doAsync {
            val result = RequestForcastCommand("94043").execute()
           uiThread { forecast_list.adapter = ForecastListAdapter(result) }
        }


        
    }
}
