package zhirenko.com.zhcommon.sections

import zhirenko.com.zhcommon.adapters.ListItemSectionData
import zhirenko.com.zhcommon.models.Event
import zhirenko.com.zhcommon.models.Item
import zhirenko.com.zhcommon.models.Move
import zhirenko.com.zhcommon.models.Notice
import javax.inject.Inject

/**
 * SectionMapper вернёт все заполненные секции
 * ему приходят данные, он отдаёт заполненные секции
  */
class SectionMapper @Inject constructor() {
    fun mapToSections(list : List<Item>): List<ListItemSectionData> {

        val sectionList : MutableList<ListItemSectionData> = arrayListOf()
        list.forEach {
            when(it) {
                is Notice -> sectionList.add(NoticeSection.create(it.flightDate.toString(), it.gate))
                is Move -> sectionList.add(MoveSection.create(it.fromPlace, it.toPlace, 42f))
                is Event -> sectionList.add(EventSection.create(it.startTime, it.endTime, it.name))
            }
        }

        return  sectionList.toList()
    }
}