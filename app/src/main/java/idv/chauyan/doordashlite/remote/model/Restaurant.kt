package idv.chauyan.doordashlite.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Restaurant(
  val id: Long,
  val name: String,
  val description: String,
  @Json(name = "cover_img_url")
  val coverImage: String,
  val status: String
)