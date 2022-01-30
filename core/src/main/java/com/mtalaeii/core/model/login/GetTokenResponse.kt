package com.mtalaeii.core.model.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetTokenResponse (

  @SerializedName("token_type"    ) var tokenType    : String? = null,
  @SerializedName("expries_in"    ) var expriesIn    : String?    = null,
  @SerializedName("access_token"  ) var accessToken  : String? = null,
  @SerializedName("refresh_token" ) var refreshToken : String? = null

) : Parcelable