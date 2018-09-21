package zhirenko.com.zhcommon.models

data class Move(
    var fromPlace: String,
    var toPlace: String,
    var estimateTime: Float
) : Item
