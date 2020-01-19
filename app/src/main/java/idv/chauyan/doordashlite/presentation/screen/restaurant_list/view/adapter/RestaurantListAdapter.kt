package idv.chauyan.doordashlite.presentation.screen.restaurant_list.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.presentation.model.PresentationRestaurant
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.RestaurantListContract

import kotlinx.android.synthetic.main.fragment_restaurantlist.view.*

class RestaurantListAdapter(
  private var restaurants: List<PresentationRestaurant>,
  private val listener: RestaurantListContract.View.RestaurantListBehavior?
) : RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {

  private val restaurantOnClickListener: View.OnClickListener

  init {
    restaurantOnClickListener = View.OnClickListener { v ->
      val item = v.tag as PresentationRestaurant
      listener?.onSelectedRestaurant(item)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_restaurantlist, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = restaurants[position]
    Picasso
      .with(holder.restaurantLogo.context)
      .load(item.coverImage)
      .into(holder.restaurantLogo)
    holder.restaurantName.text = item.name
    holder.restaurantCategory.text = item.description
    holder.restaurantStatus.text = item.status

    with(holder.view) {
      tag = item
      setOnClickListener(restaurantOnClickListener)
    }
  }

  override fun getItemCount(): Int = restaurants.size

  fun updateRestaurants(data: List<PresentationRestaurant>) {
    this.restaurants = data
    notifyDataSetChanged()
  }

  inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val restaurantLogo: ImageView = view.restaurantLogo
    val restaurantName: TextView = view.restaurantName
    val restaurantCategory: TextView = view.restaurantCategory
    val restaurantStatus: TextView = view.restaurantStatus
  }
}
