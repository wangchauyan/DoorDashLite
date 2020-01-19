package idv.chauyan.doordashlite.presentation.model

data class PresentationRestaurant(
  val id: Long,
  val name: String,
  val description: String,
  val coverImage: String,
  val status: String
)