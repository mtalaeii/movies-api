package com.mtalaeii.search.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("poster") val poster : String,
	@SerializedName("year") val year : Int,
	@SerializedName("country") val country : String,
	@SerializedName("imdb_rating") val imdb_rating : Double,
	@SerializedName("genres") val genres : List<String>,
	@SerializedName("images") val images : List<String>
) : Parcelable