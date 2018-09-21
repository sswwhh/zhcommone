package zhirenko.com.zhcommon.mappers

import zhirenko.com.zhcommon.models.Event
import zhirenko.com.zhcommon.models.Move
import zhirenko.com.zhcommon.models.Notice
import zhirenko.com.zhcommon.sections.EventSection
import zhirenko.com.zhcommon.sections.MoveSection
import zhirenko.com.zhcommon.sections.NoticeSection
import java.util.*

fun NoticeSection.mapToNotice() : Notice {
    return Notice(Date(flightDate), gate)
}
fun MoveSection.mapToMove() : Move {
    return Move(fromPlace, toPlace, estimateTime)
}
fun EventSection.mapToEvent() : Event {
    return Event(startTime, endTime, name)
}