package com.mtalaeii.login.model

import com.google.gson.annotations.SerializedName

data class Auth (

  @SerializedName("name" ) var username : String,
  @SerializedName("password" ) var password : String,
  @SerializedName("email"    ) var email    : String

)