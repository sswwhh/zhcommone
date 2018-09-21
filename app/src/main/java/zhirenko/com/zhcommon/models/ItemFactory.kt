package zhirenko.com.zhcommon.models

import zhirenko.com.zhcommon.Ext.random
import java.util.*

class ItemFactory {

    companion object {
        fun getItem(type: Items) : Item {
            return when (type) {
                Items.NoticeItem -> Notice(Date(), "notice ${(0..10).random()}")
                Items.EventItem -> Event(Date(), Date(), "${(0..100).random()}'s name")
                Items.MoveItem -> Move("From #${(0..10).random()}", "To #${(0..10).random()}", (0..42).random().toFloat())
            }
        }
    }
}