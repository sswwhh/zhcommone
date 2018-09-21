package zhirenko.com.zhcommon.delegates

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_notice.view.*
import zhirenko.com.zhcommon.Ext.inflateItem
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.adapters.ListItemSectionData
import zhirenko.com.zhcommon.sections.NoticeSection

/**
 * Delegate class receives the responsibility of creating the section in RV
 * This section includes view, data and its representation
 */
class NoticeSectionDelegate(private val listener: (ListItemSectionData) -> Unit) : SimpleDelegate<ListItemSectionData>() {
    override fun ViewGroup.view(): View = inflateItem(R.layout.item_notice)

    override fun forViewType(item: ListItemSectionData): Boolean = item is NoticeSection

    override fun View.bindView(item: ListItemSectionData, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val noticeSection = item as NoticeSection

        tv_date.text = noticeSection.flightDate
        tv_gate.text = noticeSection.gate

        ll_main.setOnClickListener {
            listener(noticeSection)
        }
    }
}