package idv.chauyan.doordashlite.presentation.screen.restaurant_detail.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.presentation.screen.restaurant_detail.RestaurantDetailContract

class RestaurantDetailFragment : Fragment(), RestaurantDetailContract.View {

  private lateinit var presenter: RestaurantDetailContract.Presenter
  private lateinit var mapView: MapView

  /**
   * Restaurant detail contract
   */

  override fun setPresenter(presenter: RestaurantDetailContract.Presenter) {
    this.presenter = presenter
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false)

    initMaps(view, savedInstanceState)

    return view
  }

  override fun onStart() {
    super.onStart()
    mapView.onStart()
  }

  override fun onResume() {
    super.onResume()
    mapView.onResume()
  }

  override fun onPause() {
    super.onPause()
    mapView.onPause()
  }

  override fun onStop() {
    super.onStop()
    mapView.onStop()
  }

  override fun onDestroy() {
    super.onDestroy()
    mapView.onDestroy()
  }

  override fun onLowMemory() {
    super.onLowMemory()
    mapView.onLowMemory()
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    mapView.onSaveInstanceState(outState)
  }

  // private methods

  private fun initMaps(
    rootView: View,
    savedInstanceState: Bundle?
  ) {
    mapView = rootView.findViewById(R.id.mapView)
    mapView.apply {
      onCreate(savedInstanceState)
      getMapAsync { mapBoxMap ->
        mapBoxMap.setStyle(Style.MAPBOX_STREETS)
      }
    }
  }
}
