package com.bugli.justfun.utils

import android.util.Log

object LogUtil {

    //等于assets下justfun.xml里的isDebug
    private const val isDebug = true

    fun d(TAG: String, msg: String) {
        if (isDebug) {
            Log.d(TAG, msg)
        }
    }

    fun w(TAG: String, msg: String) {
        if (isDebug) {
            Log.w(TAG, msg)
        }
    }

    fun e(TAG: String, msg: String) {
        if (isDebug) {
            Log.e(TAG, msg)
        }
    }

    fun i(TAG: String, msg: String) {
        if (isDebug) {
            Log.i(TAG, msg)
        }
    }

    fun v(TAG: String, msg: String) {
        if (isDebug) {
            Log.v(TAG, msg)
        }
    }


}