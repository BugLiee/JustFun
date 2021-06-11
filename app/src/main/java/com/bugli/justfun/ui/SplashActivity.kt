package com.bugli.justfun.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.bugli.justfun.R
import com.bugli.justfun.common.Constants.Companion.preTAG
import com.bugli.justfun.utils.LogUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : Activity() {
    val TAG = preTAG + "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        //以下代码可以有效解决home键回到桌面，点击icon回到应用再出现一次闪屏页
        if (!isTaskRoot) {
            finish()
        }
        doInSplash()
    }

    private fun doInSplash() {
        LogUtil.d(TAG, "doInSplash: ")
        setContentView(R.layout.activity_splash)
        GlobalScope.launch {
            LogUtil.d(TAG, "delay: ")
            delay(500)
            jump2MainActivity()
        }

    }

    private fun jump2MainActivity() {
        LogUtil.d(TAG, "jump2MainActivity: ")
        val mIntent = Intent(this, MainActivity::class.java)
        startActivity(mIntent)
        finish()
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