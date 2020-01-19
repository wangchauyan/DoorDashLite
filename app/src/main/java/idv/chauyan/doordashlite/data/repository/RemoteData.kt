package idv.chauyan.doordashlite.data.repository

import idv.chauyan.doordashlite.remote.RemoteDataImpl
import idv.chauyan.doordashlite.remote.api.RestaurantAPI
import idv.chauyan.doordashlite.remote.model.Restaurant

interface RemoteData {
  suspend fun getRestaurantList(
    lat: Double,
    lng: Double,
    offset: Int,
    limit: Int
  ): List<Restaurant>

  companion object {
    fun createRemoteDataSource(debug: Boolean): RemoteData {
      return RemoteDataImpl(RestaurantAPI.create(debug))
    }
  }
}