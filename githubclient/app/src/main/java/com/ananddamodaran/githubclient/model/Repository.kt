package com.ananddamodaran.githubclient.model

import com.google.gson.annotations.SerializedName

/**
 * Created by anand on 3/22/18.
 */
data class Repository(val name: String?, val description: String?,
                      @SerializedName("html_url") val url:String?,
                      @SerializedName("stargazers_count") val stars: Int? )