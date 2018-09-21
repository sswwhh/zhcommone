package zhirenko.com.zhcommon.delegates

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_event.view.*
import zhirenko.com.zhcommon.Ext.inflateItem
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.adapters.ListItemSectionData
import zhirenko.com.zhcommon.sections.EventSection

/**
 * Delegate class receives the responsibility of creating the section in RV
 * This section includes view, data and its representation
 */
class EventSectionDelegate(private val listener: (ListItemSectionData) -> Unit) : SimpleDelegate<ListItemSectionData>() {
    override fun ViewGroup.view(): View = inflateItem(R.layout.item_event)

    override fun forViewType(item: ListItemSectionData): Boolean = item is EventSection

    override fun View.bindView(item: ListItemSectionData, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val eventSection = item as EventSection

        tv_start.text = eventSection.startTime.toString()
        tv_end.text = eventSection.endTime.toString()
        tv_name.text = eventSection.name

        ll_main.setOnClickListener {
            listener(eventSection)
        }
    }
}