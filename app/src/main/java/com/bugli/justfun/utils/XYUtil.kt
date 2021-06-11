package com.bugli.justfun.utils

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.View
import android.view.WindowManager

object XYUtil {
    //
    //获取屏幕宽高
    fun getWinWH(context: Context): Point {
        val windowManager = context.applicationContext
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val outPoint = Point()
        if (Build.VERSION.SDK_INT >= 19) {
            // 可能有虚拟按键的情况
            display.getRealSize(outPoint)
        } else {
            // 不可能有虚拟按键
            display.getSize(outPoint)
        }
        return outPoint
    }

    fun dp2px(context: Context, dipValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

    // View宽，高
    fun getLocation(v: View): IntArray {
        val loc = IntArray(2)
        val w = View.MeasureSpec.makeMeasureSpec(
            0,
            View.MeasureSpec.UNSPECIFIED
        )
        val h = View.MeasureSpec.makeMeasureSpec(
            0,
            View.MeasureSpec.UNSPECIFIED
        )
        v.measure(w, h)
        loc[0] = v.measuredWidth
        loc[1] = v.measuredHeight
        return loc
    }
}