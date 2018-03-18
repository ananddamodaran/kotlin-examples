package com.ananddamodaran.chapter1.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.ananddamodaran.chapter1.domain.model.ForecastList

/**
 * Created by anand on 3/12/18.
 */
/*
class ForecastListAdapter(val items: List<String>) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val textView = TextView(parent?.context)
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textView?.text = items[position]
    }

    class ViewHolder(val textView:TextView) : RecyclerView.ViewHolder(textView)

}*/
class  ForecastListAdapter(val weekForecast: ForecastList):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return  ViewHolder(TextView(parent?.context))
    }

    override fun getItemCount(): Int {
       return weekForecast.dailyForecast.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]){
            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }


    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

}
