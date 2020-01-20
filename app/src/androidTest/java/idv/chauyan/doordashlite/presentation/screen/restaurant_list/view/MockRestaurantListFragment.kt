package idv.chauyan.doordashlite.presentation.screen.restaurant_list.view

import android.os.Bundle
import idv.chauyan.doordashlite.domain.DomainRepository
import idv.chauyan.doordashlite.domain.usecase.GetRestaurantList
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.model.MockRestaurantListModel
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.presenter.MockRestaurantListPresenter

/**
 * Mock restaurant list view implementation.
 * The purpose of this mock instance is to connect with [MockRestaurantListPresenter] and
 * [MockRestaurantListModel] to get mock data from [TestWebServer].
 */
class MockRestaurantListFragment : RestaurantListFragment() {

  private lateinit var presenter: MockRestaurantListPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // setup mock presenter and enable the debug mode
    presenter = MockRestaurantListPresenter(
      MockRestaurantListModel(GetRestaurantList(DomainRepository.create(true))),
      this
    )
    this.setPresenter(presenter)
  }
}