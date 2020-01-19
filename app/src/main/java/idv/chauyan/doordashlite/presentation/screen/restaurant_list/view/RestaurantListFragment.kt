package idv.chauyan.doordashlite.presentation.screen.restaurant_list.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.view.adapter.RestaurantListAdapter

open class RestaurantListFragment : Fragment(), RestaurantListContract.View {

  private var columnCount = 1
  private var listener: RestaurantListContract.View.RestaurantListBehavior? = null
  private lateinit var restaurantListAdapter: RestaurantListAdapter
  private lateinit var presenter: RestaurantListContract.Presenter

  override fun setPresenter(presenter: RestaurantListContract.Presenter) {
    this.presenter = presenter
  }

  override fun updateRestaurants(data: List<PresentationRestaurant>) {
    restaurantListAdapter.updateRestaurants(data)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(R.layout.fragment_restaurantlist_list, container, false)

    // Set the adapter
    if (view is RecyclerView) {

      restaurantListAdapter = RestaurantListAdapter(arrayListOf(), listener)

      with(view) {
        layoutManager = when {
          columnCount <= 1 -> LinearLayoutManager(context)
          else -> GridLayoutManager(context, columnCount)
        }
        adapter = restaurantListAdapter
      }
    }
    return view
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is RestaurantListContract.View.RestaurantListBehavior) {
      listener = context
    }
  }

  override fun onDetach() {
    super.onDetach()
    listener = null
  }

  override fun onResume() {
    super.onResume()

    /**
     * Get restaurant list
     */
    presenter.getRestaurantList()
  }
}
