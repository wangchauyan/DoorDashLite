package idv.chauyan.doordashlite.mockserver

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest


/**
 * Test web server for setting up all mock data we need in the UIs tests.
 */
class TestWebServer {

  private lateinit var mockWebServer: MockWebServer

  fun onStart() {
    mockWebServer = MockWebServer()
    mockWebServer.dispatcher = APIDispatcher()
    mockWebServer.start(8000)
  }

  fun onDestroy() {
    mockWebServer.shutdown()
  }

  /**
   * Dispatcher for returning different mock data based on the [Request] path
   */
  class APIDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
      when (request.path) {
        "/v2/restaurant/?lat=37.42274&lng=-122.139956&offset=0&limit=10" -> {
          return MockResponse().setResponseCode(200).setBody(Config.getRestaurantList())
        }
        "/v2/restaurant/{restaurant_id}/" -> {
          return MockResponse().setResponseCode(200).setBody("")
        }
      }
      return MockResponse().setResponseCode(404)
    }

  }
}