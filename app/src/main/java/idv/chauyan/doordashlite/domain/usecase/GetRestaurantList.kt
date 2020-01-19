package idv.chauyan.doordashlite.domain.usecase

import idv.chauyan.doordashlite.domain.DomainRepository
import idv.chauyan.doordashlite.domain.model.DomainRestaurant
import idv.chauyan.doordashlite.domain.model.exts.toDomainModel

class GetRestaurantList(
  private val domainRepository: DomainRepository
) {

  suspend fun get(
    lat: Double,
    lng: Double,
    offset: Int,
    limit: Int
  ): List<DomainRestaurant> = domainRepository.getRestaurantList(
    lat, lng, offset, limit
  ).map { it.toDomainModel() }
}