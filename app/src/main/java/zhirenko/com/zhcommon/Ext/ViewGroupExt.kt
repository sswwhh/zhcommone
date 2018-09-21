package zhirenko.com.zhcommon.Ext

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


inline fun ViewGroup.inflateItem(@LayoutRes layoutRes: Int, init: View.() -> Unit = {}): View {
    val view = LayoutInflater.from(context).inflate(layoutRes, this, false)
    view.init()
    return view
}