package idv.chauyan.doordashlite.presentation.model.exts

import idv.chauyan.doordashlite.domain.model.DomainRestaurant
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant

fun DomainRestaurant.toPresentationModel(): PresentationRestaurant = PresentationRestaurant(
  id, name, description, coverImage, status
)

fun PresentationRestaurant.toDomainModel(): DomainRestaurant = DomainRestaurant(
  id, name, description, coverImage, status
)