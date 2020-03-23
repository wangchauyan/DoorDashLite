package idv.chauyan.doordashlite

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.mapbox.mapboxsdk.Mapbox
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

  @SuppressLint("ResourceAsColor")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Mapbox.getInstance(
      this,
      "pk.eyJ1IjoiY2hhdXlhbiIsImEiOiJjano3MWc3NmUwMWt6M21vNzZwaG1xbXVwIn0.BP1AUvP1mhX9mhiqIGN2uw"
    )
    setContentView(R.layout.activity_main)

    fragmentContainer.apply {
      systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
          View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }

    showRestaurantList()
  }

  override fun onSelectedRestaurant(restaurant: PresentationRestaurant) {
    applyFragment(RestaurantDetailFragment())
  }

  // private methods

  private fun showRestaurantList() {
    val listFragment = RestaurantListFragment()
    listFragment.setPresenter(
      RestaurantListPresenter(
        RestaurantListModel(GetRestaurantList(DomainRepository.create(false))),
        listFragment
      ))
    applyFragment(listFragment)
  }

  private fun applyFragment(fg: Fragment) {
    supportFragmentManager
      .beginTransaction()
      .apply {
        replace(R.id.fragmentContainer, fg)
        addToBackStack(null)
      }
      .commit()
  }
}
