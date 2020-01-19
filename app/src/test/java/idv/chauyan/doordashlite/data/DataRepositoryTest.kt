package idv.chauyan.doordashlite.data

import com.google.common.truth.Truth.assertThat
import idv.chauyan.doordashlite.data.repository.RemoteData
import idv.chauyan.doordashlite.remote.model.Restaurant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DataRepositoryTest {

  private lateinit var restaurant: Restaurant

  @Mock
  private lateinit var remoteData: RemoteData

  @InjectMocks
  private lateinit var dataRepository: DataRepository

  @Before
  fun setUp() {
    restaurant = Restaurant(
      id = 200,
      name = "Test Remote Restaurant",
      description = "Test Remote Description",
      coverImage = "https://www.google.com",
      status = "Test Remote Status"
    )
  }

  @ExperimentalCoroutinesApi
  @Test
  fun `get empty restaurant list`() {
    runBlockingTest {
      val lat = 0.0
      val lng = 0.0
      val offset = 0
      val limit = 0

      Mockito.`when`(remoteData.getRestaurantList(lat, lng, offset, limit))
        .thenReturn(arrayListOf())
      val data = dataRepository.getRestaurantList(lat, lng, offset, limit)
      Mockito.verify(remoteData).getRestaurantList(lat, lng, offset, limit)

      assertThat(data).isEmpty()
    }
  }

  @ExperimentalCoroutinesApi
  @Test
  fun `get restaurant list`() {
    runBlockingTest {
      val lat = 0.0
      val lng = 0.0
      val offset = 0
      val limit = 1

      val dataList = arrayListOf<Restaurant>()
      dataList.add(restaurant)

      Mockito.`when`(remoteData.getRestaurantList(lat, lng, offset, limit))
        .thenReturn(dataList)
      val data = dataRepository.getRestaurantList(lat, lng, offset, limit)
      Mockito.verify(remoteData).getRestaurantList(lat, lng, offset, limit)

      assertThat(data).isNotEmpty()
      assertThat(data.size).isEqualTo(1)
      assertThat(data.first().id).isEqualTo(restaurant.id)
      assertThat(data.first().name).isEqualTo(restaurant.name)
      assertThat(data.first().description).isEqualTo(restaurant.description)
      assertThat(data.first().coverImage).isEqualTo(restaurant.coverImage)
      assertThat(data.first().status).isEqualTo(restaurant.status)
    }
  }
}