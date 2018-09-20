package zhirenko.com.zhcommon.models

import java.util.*

class Move : Item {
    var fromPlace: String? = null
    var toPlace: String? = null
    var estimateTime: Date? = null // TODO Time Interval
}
