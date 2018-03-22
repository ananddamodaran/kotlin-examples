package com.ananddamodaran.githubclient.model

import com.google.gson.annotations.SerializedName

/**
 * Created by anand on 3/22/18.
 */
data class RepositoryResponse(@SerializedName("items")
                              val repositories: Collection<Repository>)