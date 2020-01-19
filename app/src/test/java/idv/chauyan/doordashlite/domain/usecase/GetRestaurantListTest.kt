package idv.chauyan.doordashlite.domain.usecase

import idv.chauyan.doordashlite.data.model.DataRestaurant
import idv.chauyan.doordashlite.domain.DomainRepository
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
class GetRestaurantListTest {

  @Mock
  private lateinit var domainRepository: DomainRepository

  @InjectMocks
  private lateinit var getRestaurantList: GetRestaurantList

  @ExperimentalCoroutinesApi
  @Test
  fun getRestaurantList() {
    runBlockingTest {
      val lat = 0.0
      val lng = 0.0
      val offset = 0
      val limit = 25

      val dataRestaurantList = listOf<DataRestaurant>()

      `when`(domainRepository.getRestaurantList(
        lat, lng, offset, limit
      )).thenReturn(dataRestaurantList)

      getRestaurantList.get(lat, lng, offset, limit)

      verify(domainRepository).getRestaurantList(lat, lng, offset, limit)
    }
  }
}