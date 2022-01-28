package com.mtalaeii.core.model.search

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResponse (

	@SerializedName("data") val data : List<Data>,
	@SerializedName("metadata") val metadata : Metadata
) : Parcelable