package idv.chauyan.doordashlite.presentation.screen.restaurant_list.view

import android.os.Bundle
import idv.chauyan.doordashlite.domain.DomainRepository
import idv.chauyan.doordashlite.domain.usecase.GetRestaurantList
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.model.MockRestaurantListModel
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.presenter.MockRestaurantListPresenter

class MockRestaurantListFragment : RestaurantListFragment() {

  private lateinit var presenter: MockRestaurantListPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // setup mock presenter
    presenter = MockRestaurantListPresenter(
      MockRestaurantListModel(GetRestaurantList(DomainRepository.create(true))),
      this
    )
    this.setPresenter(presenter)
  }
}