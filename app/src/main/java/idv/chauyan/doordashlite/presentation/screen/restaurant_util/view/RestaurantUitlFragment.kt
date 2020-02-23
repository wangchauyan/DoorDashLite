package idv.chauyan.doordashlite.presentation.screen.restaurant_util.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class RestaurantUitlFragment : BottomSheetDialogFragment() {
  private var rootView: View? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {
    rootView = super.onCreateView(inflater, container, savedInstanceState)
    return rootView
  }
}