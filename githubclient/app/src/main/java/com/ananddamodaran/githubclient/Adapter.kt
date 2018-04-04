package com.ananddamodaran.githubclient

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ananddamodaran.githubclient.model.Repository
import kotlinx.android.synthetic.main.listitem.view.*
import javax.security.auth.callback.Callback

/**
 * Created by anand on 3/22/18.
 */
class Adapter(private val callback: (Repository) ->Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var repos: MutableList<Repository> = ArrayList()

    fun setRepositories(list: Collection<Repository> ){
        repos.clear()
        repos.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.listitem,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val repository = repos.get(position)
        holder?.itemView?.repo_title?.text = repository.name
        holder?.itemView?.description?.text = repository.description
        holder?.itemView?.stars?.text = "${repository.stars.toString()}  stars"
        holder?.itemView?.setOnClickListener{
            callback.invoke(repository)
        }

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

}