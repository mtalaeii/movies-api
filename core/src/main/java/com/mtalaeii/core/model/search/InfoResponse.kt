package com.mtalaeii.core.model.search

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoResponse (

	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("poster") val poster : String,
	@SerializedName("year") val year : Int,
	@SerializedName("rated") val rated : String,
	@SerializedName("released") val released : String,
	@SerializedName("runtime") val runtime : String,
	@SerializedName("director") val director : String,
	@SerializedName("writer") val writer : String,
	@SerializedName("actors") val actors : String,
	@SerializedName("plot") val plot : String,
	@SerializedName("country") val country : String,
	@SerializedName("awards") val awards : String,
	@SerializedName("metascore") val metascore : Int,
	@SerializedName("imdb_rating") val imdb_rating : Double,
	@SerializedName("imdb_votes") val imdb_votes : String,
	@SerializedName("imdb_id") val imdb_id : String,
	@SerializedName("type") val type : String,
	@SerializedName("genres") val genres : List<String>,
	@SerializedName("images") val images : List<String>
) : Parcelable