package idv.chauyan.doordashlite

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import idv.chauyan.doordashlite.domain.DomainRepository
import idv.chauyan.doordashlite.domain.usecase.GetRestaurantList
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant
import idv.chauyan.doordashlite.presentation.screen.restaurant_detail.view.RestaurantDetailFragment
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.model.RestaurantListModel
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.presenter.RestaurantListPresenter
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.view.RestaurantListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
  FragmentActivity(),
  RestaurantListContract.View.RestaurantListBehavior {

  private lateinit var listFragment: RestaurantListFragment

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    listFragment = restaurantList as RestaurantListFragment
    listFragment.apply {
      setPresenter(
        RestaurantListPresenter(
          RestaurantListModel(GetRestaurantList(DomainRepository.create(false))),
          listFragment
        )
      )
    }
  }

  override fun onSelectedRestaurant(restaurant: PresentationRestaurant) {
    // enter restaurant detail information screen
    supportFragmentManager
      .beginTransaction()
      .apply {
        replace(R.id.fragmentContainer, RestaurantDetailFragment())
        addToBackStack(null)
      }
      .commit()
  }
}
