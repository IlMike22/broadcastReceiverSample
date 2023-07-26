package com.example.broadcastreceiversample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class TestReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == "TEST_ACTION") {
            println("Received test intent. This should be done in another app btw.")
        }
    }
}