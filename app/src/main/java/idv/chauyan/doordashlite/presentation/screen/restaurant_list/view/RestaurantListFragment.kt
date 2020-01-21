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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.view.adapter.RestaurantListAdapter

open class RestaurantListFragment : Fragment(), RestaurantListContract.View {


  // customize the recyclerview layout
  private var columnCount = 1
  private var loadMore = false
  private val pageSize = 10
  private var since = 0

  private var listener: RestaurantListContract.View.RestaurantListBehavior? = null
  private lateinit var restaurantListAdapter: RestaurantListAdapter
  private lateinit var presenter: RestaurantListContract.Presenter
  private lateinit var restaurantList: RecyclerView
  private lateinit var restaurantRefresher: SwipeRefreshLayout

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

    restaurantList = view.findViewById(R.id.list)
    restaurantRefresher = view.findViewById(R.id.refresher)

    restaurantList.apply {
      restaurantListAdapter = RestaurantListAdapter(arrayListOf(), listener)
      layoutManager = when {
        columnCount <= 1 -> LinearLayoutManager(activity)
        else -> GridLayoutManager(activity, columnCount)
      }
      adapter = restaurantListAdapter
    }

    restaurantRefresher.apply {
      setOnRefreshListener {
        getRestaurantList(true)
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

    getRestaurantList(false)
  }

  /**
   * Fetch restaurant list from server side
   */
  fun getRestaurantList(refreshing: Boolean) {
    // update refresher
    if (refreshing) {
      restaurantRefresher.isRefreshing = false
      since = 0
    }

    // get restaurant list
    presenter.getRestaurantList(
      offset = since,
      limit = pageSize
    )
  }
}
