package idv.chauyan.doordashlite.presentation.screen.restaurant_detail.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.presentation.screen.restaurant_detail.RestaurantDetailContract

/**
 * A simple [Fragment] subclass.
 */
class RestaurantDetailFragment : Fragment(), RestaurantDetailContract.View {

  private lateinit var presenter: RestaurantDetailContract.Presenter

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
    return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
  }


}
