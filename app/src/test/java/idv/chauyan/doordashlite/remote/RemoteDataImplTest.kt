package idv.chauyan.doordashlite.remote

import idv.chauyan.doordashlite.remote.api.RestaurantAPI
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDataImplTest {

  @Mock
  private lateinit var api: RestaurantAPI

  @InjectMocks
  private lateinit var remoteDataImpl: RemoteDataImpl

  @ExperimentalCoroutinesApi
  @Test
  fun getRestaurantList() {
    runBlockingTest {
      val lat = 0.0
      val lng = 0.0
      val offset = 0
      val limit = 25

      `when`(api.getRestaurantList(lat, lng, offset, limit)).thenReturn(arrayListOf())
      remoteDataImpl.getRestaurantList(lat, lng, offset, limit)
      verify(api).getRestaurantList(lat, lng, offset, limit)
    }
  }
}