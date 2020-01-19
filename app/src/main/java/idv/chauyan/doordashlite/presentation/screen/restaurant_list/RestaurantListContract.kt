package idv.chauyan.doordashlite.presentation.screen.restaurant_list

import idv.chauyan.doordashlite.presentation.BasePresenter
import idv.chauyan.doordashlite.presentation.BaseView
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant

/**
 * Contract for Model, View, Presenter
 */
interface RestaurantListContract {

  interface Model {
    suspend fun getRestaurantList(
      lat: Double,
      lng: Double,
      offset: Int,
      limit: Int
    ): List<PresentationRestaurant>
  }

  interface Presenter : BasePresenter {
    fun getRestaurantList(
      lat: Double = 37.422740,
      lng: Double = -122.139956,
      offset: Int = 0,
      limit: Int = 10
    )
  }

  interface View : BaseView<Presenter> {

    fun updateRestaurants(data: List<PresentationRestaurant>)

    interface RestaurantListBehavior {
      fun onSelectedRestaurant(restaurant: PresentationRestaurant)
    }
  }
}