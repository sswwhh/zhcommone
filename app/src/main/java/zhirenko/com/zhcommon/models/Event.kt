package zhirenko.com.zhcommon.models

import java.util.*

data class Event (
    var startTime: Date,
    var endTime: Date,
    var name: String
    ) : Item