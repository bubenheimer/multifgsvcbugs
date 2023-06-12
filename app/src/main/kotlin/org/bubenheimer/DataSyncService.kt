package org.bubenheimer

import android.app.Notification
import android.app.Notification.CATEGORY_SERVICE
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.Q
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE
import org.bubenheimer.R.drawable.ic_stat_name
import org.bubenheimer.R.id.notification_id_service_1
import org.bubenheimer.R.string.channelid

class DataSyncService : Service() {
    override fun onCreate() {
        Log.d("DataSyncService", "onCreate()")

        super.onCreate()

        val notification: Notification =
                NotificationCompat.Builder(this, getString(channelid))
                        .setContentTitle("Foreground service in progress")
                        .setCategory(CATEGORY_SERVICE)
                        .setOngoing(true)
                        .setSmallIcon(ic_stat_name)
                        .setForegroundServiceBehavior(FOREGROUND_SERVICE_IMMEDIATE)
                        .build()

        if (Q <= SDK_INT) {
            startForeground(
                notification_id_service_1,
                notification,
                FOREGROUND_SERVICE_TYPE_DATA_SYNC
            )
        } else startForeground(notification_id_service_1, notification)
    }

    override fun onDestroy() {
        Log.d("DataSyncService", "onDestroy()")

        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
