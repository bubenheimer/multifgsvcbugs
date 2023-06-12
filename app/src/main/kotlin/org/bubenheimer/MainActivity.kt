package org.bubenheimer

import android.Manifest.permission.POST_NOTIFICATIONS
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    @SuppressLint("InlinedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Column(Modifier
                        .fillMaxSize()
                ) {
                    val context = LocalContext.current

                    TextButton(
                        onClick = {
                            requestPermissions(arrayOf(POST_NOTIFICATIONS), 100)
                        }
                    ) { Text("Request POST_NOTIFICATIONS permission") }

                    TextButton(
                            onClick = {
                                context.startService(Intent(context, DataSyncService::class.java))
                            }
                    ) { Text("Start data sync service") }

                    TextButton(
                            onClick = {
                                context.stopService(Intent(context, DataSyncService::class.java))
                            }
                    ) { Text("Stop data sync service") }

                    TextButton(
                            onClick = {
                                context.startService(Intent(context, SoundService::class.java))
                            }
                    ) { Text("Start sound service") }

                    TextButton(
                            onClick = {
                                context.stopService(Intent(context, SoundService::class.java))
                            }
                    ) { Text("Stop sound service") }
                }
            }
        }
    }
}
