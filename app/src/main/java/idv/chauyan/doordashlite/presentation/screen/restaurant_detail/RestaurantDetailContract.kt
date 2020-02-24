package idv.chauyan.doordashlite.presentation.screen.restaurant_detail

import idv.chauyan.doordashlite.presentation.BasePresenter
import idv.chauyan.doordashlite.presentation.BaseView

interface RestaurantDetailContract {
  interface Model
  interface View : BaseView<Presenter>
  interface Presenter : BasePresenter
}