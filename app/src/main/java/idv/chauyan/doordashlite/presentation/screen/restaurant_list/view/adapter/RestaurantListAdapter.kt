package idv.chauyan.doordashlite.presentation.screen.restaurant_list.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract

class RestaurantListAdapter(
  private var restaurants: ArrayList<PresentationRestaurant>,
  private val listener: RestaurantListContract.View.RestaurantListBehavior?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  enum class ItemType {
    TYPE_RESTAURANT,
    TYPE_LOADING
  }

  private val restaurantOnClickListener: View.OnClickListener

  init {
    restaurantOnClickListener = View.OnClickListener { v ->
      val item = v.tag as PresentationRestaurant
      listener?.onSelectedRestaurant(item)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
      ItemType.TYPE_RESTAURANT.ordinal -> {
        val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.fragment_restaurant_item, parent, false)
        RestaurantItem(view)
      }
      else -> {
        val view = LayoutInflater.from(parent.context)
          .inflate(R.layout.fragment_restaurant_loading, parent, false)
        RestaurantLoading(view)
      }
    }
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (holder is RestaurantItem) {
      val item = restaurants[position]
      Picasso.get()
        .load(item.coverImage)
        .into(holder.restaurantLogo)
      holder.restaurantName.text = item.name
      holder.restaurantCategory.text = item.description
      holder.restaurantStatus.text = item.status

      with(holder.view) {
        tag = item
        setOnClickListener(restaurantOnClickListener)
      }
    } else if (holder is RestaurantLoading) {
      holder.restaurantLoading.isIndeterminate = true
    }
  }

  override fun getItemCount(): Int = restaurants.size

  override fun getItemViewType(position: Int): Int {
    return if (restaurants[position].isLoading)
      ItemType.TYPE_LOADING.ordinal
    else
      ItemType.TYPE_RESTAURANT.ordinal
  }

  fun updateRestaurants(
    data: List<PresentationRestaurant>,
    refreshing: Boolean
  ) {
    if (refreshing) this.restaurants.clear()
    this.restaurants.addAll(data)
    notifyDataSetChanged()
  }

  fun showLoading() {
    restaurants.add(
      PresentationRestaurant(
        0, "", "", "", "", true
      )
    )
    notifyItemInserted(restaurants.size - 1)
  }

  fun dismissLoading() {
    restaurants.removeAt(restaurants.lastIndex)
    notifyItemRemoved(restaurants.size)
  }

  inner class RestaurantItem(val view: View) : RecyclerView.ViewHolder(view) {
    val restaurantLogo: ImageView = view.findViewById(R.id.restaurantLogo)
    val restaurantName: TextView = view.findViewById(R.id.restaurantName)
    val restaurantCategory: TextView = view.findViewById(R.id.restaurantCategory)
    val restaurantStatus: TextView = view.findViewById(R.id.restaurantStatus)
  }

  inner class RestaurantLoading(val view: View) : RecyclerView.ViewHolder(view) {
    val restaurantLoading: ProgressBar = view.findViewById(R.id.restaurantLoading)
  }
}
