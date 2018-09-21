package zhirenko.com.zhcommon.models

import java.io.Serializable
import java.util.*

data class Notice(var flightDate : Date, var gate: String) : Item, Serializable