package com.ananddamodaran.chapter1.domain.commands

import com.ananddamodaran.chapter1.ForecastRequest
import com.ananddamodaran.chapter1.domain.mapper.ForecastDataMapper
import com.ananddamodaran.chapter1.domain.model.ForecastList

/**
 * Created by anand on 3/19/18.
 */
class RequestForcastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}