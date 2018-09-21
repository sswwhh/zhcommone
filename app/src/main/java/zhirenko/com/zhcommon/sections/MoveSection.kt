package zhirenko.com.zhcommon.sections

import zhirenko.com.zhcommon.adapters.ListItemSectionData

data class MoveSection(var fromPlace: String, var toPlace: String, var estimateTime: Float) : ListItemSectionData {

    companion object {
        fun create(fromPlace: String, toPlace: String, estimateTime: Float) : MoveSection {
            return MoveSection(fromPlace, toPlace, estimateTime)
        }
    }
}
