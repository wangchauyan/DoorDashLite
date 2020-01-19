package idv.chauyan.doordashlite.data

import idv.chauyan.doordashlite.data.model.DataRestaurant
import idv.chauyan.doordashlite.data.model.exts.toDataModel
import idv.chauyan.doordashlite.data.repository.RemoteData
import idv.chauyan.doordashlite.domain.DomainRepository

class DataRepository(
  private val remoteData: RemoteData
) : DomainRepository {

  override suspend fun getRestaurantList(
    lat: Double,
    lng: Double,
    offset: Int,
    limit: Int
  ): List<DataRestaurant> = remoteData.getRestaurantList(
    lat, lng, offset, limit
  ).map {
    it.toDataModel()
  }
}