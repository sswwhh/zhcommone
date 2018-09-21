package zhirenko.com.zhcommon.sections

import zhirenko.com.zhcommon.adapters.ListItemSectionData
import java.util.*

data class EventSection(var startTime: Date, var endTime: Date, var name: String) : ListItemSectionData {

    companion object {
        fun create(startTime: Date, endTime: Date, name: String) : EventSection {
            return EventSection(startTime, endTime, name)
        }
    }
}
