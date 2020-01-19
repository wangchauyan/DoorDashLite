package idv.chauyan.doordashlite.presentation.screen.restaurant_list

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import idv.chauyan.doordashlite.R
import idv.chauyan.doordashlite.mockserver.TestWebServer
import idv.chauyan.doordashlite.presentation.screen.restaurant_list.view.MockRestaurantListFragment
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class RestaurantListFragmentTest {

  private lateinit var testWebServer: TestWebServer

  @Before
  fun setUp() {
    testWebServer = TestWebServer()
    testWebServer.onStart()
  }

  @After
  fun tearDown() {
    testWebServer.onDestroy()
  }

  @Test
  fun shouldDisplayRetaurantList() {

    launchFragmentInContainer<MockRestaurantListFragment>()
    onView(withId(R.id.list)).check(matches(isDisplayed()))
  }
}