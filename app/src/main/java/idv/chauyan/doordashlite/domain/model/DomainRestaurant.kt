package idv.chauyan.doordashlite.domain.model

data class DomainRestaurant(
  val id: Long,
  val name: String,
  val description: String,
  val coverImage: String,
  val status: String
)