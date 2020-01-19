package idv.chauyan.doordashlite.remote

import idv.chauyan.doordashlite.data.repository.RemoteData
import idv.chauyan.doordashlite.remote.api.RestaurantAPI
import idv.chauyan.doordashlite.remote.model.Restaurant

class RemoteDataImpl(
  private val api: RestaurantAPI
) : RemoteData {

  override suspend fun getRestaurantList(
    lat: Double,
    lng: Double,
    offset: Int,
    limit: Int
  ): List<Restaurant> {
    return api.getRestaurantList(
      lat, lng, offset, limit
    )
  }
}