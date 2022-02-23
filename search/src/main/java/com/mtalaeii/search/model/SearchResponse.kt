package com.mtalaeii.search.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResponse (

    @SerializedName("data") val data : List<Data>,
    @SerializedName("metadata") val metadata : Metadata
) : Parcelable