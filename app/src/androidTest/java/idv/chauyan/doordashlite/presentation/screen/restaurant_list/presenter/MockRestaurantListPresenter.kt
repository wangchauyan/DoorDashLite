package idv.chauyan.doordashlite.presentation.screen.restaurant_list.presenter

import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract
import kotlinx.coroutines.runBlocking

class MockRestaurantListPresenter(
  private val restaurantListModel: RestaurantListContract.Model,
  private val restaurantListView: RestaurantListContract.View
) : RestaurantListContract.Presenter {

  override fun getRestaurantList(
    lat: Double,
    lng: Double,
    offset: Int,
    limit: Int
  ) {
    runBlocking {
      val data = restaurantListModel.getRestaurantList(
        lat, lng, offset, limit
      )
      restaurantListView.updateRestaurants(data)
    }
  }
}