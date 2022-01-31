package com.mtalaeii.search.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InsertResponse (

  @SerializedName("id"          ) var id         : Int?    = null,
  @SerializedName("title"       ) var title      : String? = null,
  @SerializedName("poster"      ) var poster     : String? = null,
  @SerializedName("year"        ) var year       : Int?    = null,
  @SerializedName("director"    ) var director   : String? = null,
  @SerializedName("country"     ) var country    : String? = null,
  @SerializedName("imdb_rating" ) var imdbRating : String? = null,
  @SerializedName("imdb_votes"  ) var imdbVotes  : String? = null,
  @SerializedName("imdb_id"     ) var imdbId     : String? = null

) : Parcelable