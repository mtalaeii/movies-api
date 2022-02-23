package com.mtalaeii.login.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpResponse(
    @SerializedName("name"       ) var name      : String? = null,
    @SerializedName("email"      ) var email     : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("id"         ) var id        : Int?    = null
) : Parcelable
