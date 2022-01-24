package com.mtalaeii.login.model

import com.google.gson.annotations.SerializedName


data class Auth (

  @SerializedName("username" ) var username : String? = null,
  @SerializedName("password" ) var password : String? = null,
  @SerializedName("email"    ) var email    : String? = null

)