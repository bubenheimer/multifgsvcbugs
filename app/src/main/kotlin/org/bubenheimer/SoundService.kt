package org.bubenheimer

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SoundService : Service() {
    override fun onCreate() {
        Log.d("SoundService", "onCreate()")

        super.onCreate()

        // foreground service not actually running in foreground

    //        val notification: Notification =
//            NotificationCompat.Builder(this, getString(R.string.channelid))
//                .setContentTitle("Sound service in progress")
//                .setCategory(CATEGORY_SERVICE)
//                .setOngoing(true)
//                .setSmallIcon(ic_stat_name)
//                .setForegroundServiceBehavior(FOREGROUND_SERVICE_IMMEDIATE)
//                .build()
//
//        if (Q <= SDK_INT) {
//            startForeground(
//                notification_id_service_2,
//                notification,
//                FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
//            )
//        } else startForeground(notification_id_service_2, notification)
    }

    override fun onDestroy() {
        Log.d("SoundService", "onDestroy()")

        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

//        return START_NOT_STICKY // works better - when service not in foreground
        return START_STICKY // emulate MediaSessionService behavior
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
