package zhirenko.com.zhcommon.models

import java.io.Serializable

data class Move(
    var fromPlace: String,
    var toPlace: String,
    var estimateTime: Float
) : Item, Serializable