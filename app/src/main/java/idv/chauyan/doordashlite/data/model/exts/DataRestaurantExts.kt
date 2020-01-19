package idv.chauyan.doordashlite.data.model.exts

import idv.chauyan.doordashlite.data.model.DataRestaurant
import idv.chauyan.doordashlite.remote.model.Restaurant

fun DataRestaurant.toRemoteModel(): Restaurant = Restaurant(
  id, name, description, coverImage, status
)

fun Restaurant.toDataModel(): DataRestaurant = DataRestaurant(
  id, name, description, coverImage, status
)