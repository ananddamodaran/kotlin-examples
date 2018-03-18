package com.ananddamodaran.chapter1.domain.model

/**
 * Created by anand on 3/17/18.
 */
data class ForecastList(val city:String,val country:String, val dailyForecast:List<Forecast>)
data class Forecast(val date:String,val description: String, val high: Int, val low: Int)
