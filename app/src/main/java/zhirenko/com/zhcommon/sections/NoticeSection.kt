package zhirenko.com.zhcommon.sections

import zhirenko.com.zhcommon.adapters.ListItemSectionData

data class NoticeSection(val flightDate : String, val gate: String) : ListItemSectionData {

    companion object {
        fun create(flightDate : String, gate: String) : NoticeSection {
            return NoticeSection(flightDate, gate)
        }
    }
}