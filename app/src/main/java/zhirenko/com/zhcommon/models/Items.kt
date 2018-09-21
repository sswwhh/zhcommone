package zhirenko.com.zhcommon.models

import java.util.*


enum class Items {
    NoticeItem, EventItem, MoveItem;

    companion object {
        private val VALUES : List<Items> = values().toList()
        private val SIZE = VALUES.size
        private val RANDOM = Random()

        fun randomItem(): Items {
            return VALUES[RANDOM.nextInt(SIZE)]
        }
    }
}