package idv.chauyan.doordashlite.data.model.exts

import com.google.common.truth.Truth.assertThat
import idv.chauyan.doordashlite.data.model.DataRestaurant
import idv.chauyan.doordashlite.remote.model.Restaurant
import org.junit.Before

import org.junit.Test

class DataRestaurantExtsKtTest {

  private lateinit var dataRestaurant: DataRestaurant
  private lateinit var restaurant: Restaurant

  @Before
  fun setUp() {

    dataRestaurant = DataRestaurant(
      id = 100,
      name = "Test Data Restaurant",
      description = "Test Data Description",
      coverImage = "https://chauyan.dev",
      status = "Test Data Status"
    )

    restaurant = Restaurant(
      id = 200,
      name = "Test Remote Restaurant",
      description = "Test Remote Description",
      coverImage = "https://www.google.com",
      status = "Test Remote Status"
    )
  }

  @Test
  fun toRemoteModel() {
    val remoteData = dataRestaurant.toRemoteModel()
    assertThat(remoteData).isNotNull()
    assertThat(remoteData.id).isEqualTo(dataRestaurant.id)
    assertThat(remoteData.name).isEqualTo(dataRestaurant.name)
    assertThat(remoteData.description).isEqualTo(dataRestaurant.description)
    assertThat(remoteData.coverImage).isEqualTo(dataRestaurant.coverImage)
    assertThat(remoteData.status).isEqualTo(dataRestaurant.status)
  }

  @Test
  fun toDataModel() {
    val data = restaurant.toDataModel()
    assertThat(data).isNotNull()
    assertThat(data.id).isEqualTo(restaurant.id)
    assertThat(data.name).isEqualTo(restaurant.name)
    assertThat(data.description).isEqualTo(restaurant.description)
    assertThat(data.coverImage).isEqualTo(restaurant.coverImage)
    assertThat(data.status).isEqualTo(restaurant.status)
  }
}