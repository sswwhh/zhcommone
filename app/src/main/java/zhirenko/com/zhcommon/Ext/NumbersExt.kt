package zhirenko.com.zhcommon.Ext

import java.util.*

fun IntRange.random() =
        Random().nextInt((endInclusive + 1) - start) +  start