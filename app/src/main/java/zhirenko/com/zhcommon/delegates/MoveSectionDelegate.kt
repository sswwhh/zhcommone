package zhirenko.com.zhcommon.delegates

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_move.view.*
import zhirenko.com.zhcommon.Ext.inflateItem
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.adapters.ListItemSectionData
import zhirenko.com.zhcommon.sections.MoveSection

/**
 * Delegate class receives the responsibility of creating the section in RV
 * This section includes view, data and its representation
 */
class MoveSectionDelegate(private val listener: (ListItemSectionData) -> Unit) : SimpleDelegate<ListItemSectionData>() {
    override fun ViewGroup.view(): View = inflateItem(R.layout.item_move)

    override fun forViewType(item: ListItemSectionData): Boolean = item is MoveSection

    override fun View.bindView(item: ListItemSectionData, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val moveSection = item as MoveSection

        tv_from.text = moveSection.fromPlace
        tv_to.text = moveSection.toPlace
        tv_estimate.text = moveSection.estimateTime.toString()

        ll_main.setOnClickListener {
            listener.invoke(moveSection)
        }
    }
}