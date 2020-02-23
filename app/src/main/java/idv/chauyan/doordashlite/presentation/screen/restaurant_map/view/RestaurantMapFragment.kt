package idv.chauyan.doordashlite.presentation.screen.restaurant_map.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import idv.chauyan.doordashlite.R

/**
 * A simple [Fragment] subclass.
 */
class RestaurantMapFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_restaurant_map, container, false)
  }


}
