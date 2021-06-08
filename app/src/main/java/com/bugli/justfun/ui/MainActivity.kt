package com.bugli.justfun.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.bugli.justfun.R
import com.bugli.justfun.common.Constants.Companion.preTAG
import com.bugli.justfun.utils.LogUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = preTAG + "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onStop() {
        LogUtil.d(TAG, "onStop: ")
        super.onStop()
    }

    override fun onStart() {
        LogUtil.d(TAG, "onStart: ")
        super.onStart()
    }

    override fun onRestart() {
        LogUtil.d(TAG, "onRestart: ")
        super.onRestart()
    }

    override fun onResume() {
        LogUtil.d(TAG, "onResume: ")
        super.onResume()
    }

    override fun onPause() {
        LogUtil.d(TAG, "onPause: ")
        super.onPause()
    }

    override fun onNewIntent(intent: Intent?) {
        LogUtil.d(TAG, "onNewIntent: ")
        super.onNewIntent(intent)
    }

    override fun onDestroy() {
        LogUtil.d(TAG, "onDestroy: ")
        super.onDestroy()
    }
}