package idv.chauyan.doordashlite

import android.app.Service
import android.content.Intent
import android.os.IBinder

class RemoteService : Service() {

  private val binder = object : IRemoteService.Stub() {
    override fun getPid(): Int = android.os.Process.myPid()

    override fun basicTypes(
      anInt: Int,
      aLong: Long,
      aBoolean: Boolean,
      aFloat: Float,
      aDouble: Double,
      aString: String?
    ) {
      // do nothing
    }
  }

  override fun onCreate() {
    super.onCreate()
  }

  override fun onBind(intent: Intent): IBinder = binder
}