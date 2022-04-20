package idv.chauyan.doordashlite.presentation.screen.restaurant_detail.view

import android.content.Context
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.databinding.FragmentActionsListDialogBinding
import idv.chauyan.doordashlite.databinding.FragmentActionsListDialogItemBinding

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    RestaurantActions.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 *
 * You activity (or fragment) needs to implement [CommandActions.Listener].
 */
class CommandActions : BottomSheetDialogFragment() {

  private var mListener: Listener? = null
  private lateinit var itemViewBinding: FragmentActionsListDialogBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    itemViewBinding = FragmentActionsListDialogBinding.inflate(layoutInflater)
    return itemViewBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    itemViewBinding.list.layoutManager = LinearLayoutManager(context)
    itemViewBinding.list.adapter = arguments?.getInt(ARG_ITEM_COUNT)?.let { ActionsAdapter(it) }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    val parent = parentFragment
    if (parent != null) {
      mListener = parent as Listener
    } else {
      mListener = context as Listener
    }
  }

  override fun onDetach() {
    mListener = null
    super.onDetach()
  }

  interface Listener {
    fun onActionsClicked(position: Int)
  }

  private inner class ViewHolder internal constructor(
    inflater: LayoutInflater,
    parent: ViewGroup
  ) : RecyclerView.ViewHolder(
    inflater.inflate(
      R.layout.fragment_actions_list_dialog_item,
      parent,
      false
    )
  ) {

    val text: TextView = itemView.findViewById(R.id.text)

    init {
      text.setOnClickListener {
        mListener?.let {
          it.onActionsClicked(adapterPosition)
          dismiss()
        }
      }
    }
  }

  private inner class ActionsAdapter internal constructor(private val mItemCount: Int) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.text.text = position.toString()
    }

    override fun getItemCount(): Int {
      return mItemCount
    }
  }

  companion object {

    // TODO: Customize parameters
    fun newInstance(itemCount: Int): CommandActions =
      CommandActions().apply {
        arguments = Bundle().apply {
          putInt(ARG_ITEM_COUNT, itemCount)
        }
      }

  }
}
