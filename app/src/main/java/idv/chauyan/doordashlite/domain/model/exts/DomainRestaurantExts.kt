package idv.chauyan.doordashlite.domain.model.exts

import idv.chauyan.doordashlite.data.model.DataRestaurant
import idv.chauyan.doordashlite.domain.model.DomainRestaurant

fun DomainRestaurant.toDataModel(): DataRestaurant = DataRestaurant(
  id, name, description, coverImage, status
)

fun DataRestaurant.toDomainModel(): DomainRestaurant = DomainRestaurant(
  id, name, description, coverImage, status
)