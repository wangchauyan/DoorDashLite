package idv.chauyan.doordashlite.domain

import idv.chauyan.doordashlite.data.DataRepository
import idv.chauyan.doordashlite.data.model.DataRestaurant
import idv.chauyan.doordashlite.data.repository.RemoteData

interface DomainRepository {

  /**
   * Domain layer - get restaurant list
   */
  suspend fun getRestaurantList(
    lat: Double,
    lng: Double,
    offset: Int,
    limit: Int
  ): List<DataRestaurant>

  companion object {
    fun create(debug: Boolean): DomainRepository {
      return DataRepository(RemoteData.createRemoteDataSource(debug))
    }
  }
}