package idv.chauyan.doordashlite.presentation.screen.restaurant_list.model

import idv.chauyan.doordashlite.domain.usecase.GetRestaurantList
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant
import idv.chauyan.doordashlite.presentation.model.exts.toPresentationModel
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract

class MockRestaurantListModel(
  private val getRestaurantList: GetRestaurantList
) : RestaurantListContract.Model {

  override suspend fun getRestaurantList(lat: Double, lng: Double, offset: Int,
    limit: Int): List<PresentationRestaurant> {
    return getRestaurantList
      .get(lat, lng, offset, limit)
      .map { it.toPresentationModel() }
  }

}