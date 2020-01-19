package idv.chauyan.doordashlite.remote.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import idv.chauyan.doordashlite.remote.model.Restaurant
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantAPI {

  @GET("v2/restaurant/")
  suspend fun getRestaurantList(
    @Query("lat") lat: Double,
    @Query("lng") lng: Double,
    @Query("offset") offset: Int,
    @Query("limit") limit: Int
  ): List<Restaurant>

  @GET("v2/restaurant/{restaurant_id}/")
  suspend fun getRestaurantDetail(
    @Path("restaurant_id") restaurantId: String
  ): Void

  companion object {
    fun create(debug: Boolean): RestaurantAPI {
      val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
      return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(
          if (debug) "http://127.0.0.1:8000/"
          else "https://api.doordash.com/")
        .build()
        .create(RestaurantAPI::class.java)
    }
  }
}