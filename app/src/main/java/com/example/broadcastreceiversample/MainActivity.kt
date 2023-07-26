package com.example.broadcastreceiversample

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.broadcastreceiversample.ui.theme.BroadcastReceiverSampleTheme

class MainActivity : ComponentActivity() {
    private val airPlanModeReceiver = AirPlanModeReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(airPlanModeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        setContent {
            BroadcastReceiverSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Button(onClick = {
                            sendBroadcast(
                                Intent("TEST_ACTION" )
                            )
                        }) {
                            Text(text = "Send broadcast")
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airPlanModeReceiver)
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BroadcastReceiverSampleTheme {
        Greeting("Android")
    }
}