package zhirenko.com.zhcommon.adapters

import android.support.v7.recyclerview.extensions.AsyncListDiffer
import android.support.v7.util.DiffUtil
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter

class ListItemsAdapter(initDelegatesManager: AdapterDelegatesManager<List<ListItemSectionData>>.() -> Unit) :
        ListDelegationAdapter<List<ListItemSectionData>>(AdapterDelegatesManager<List<ListItemSectionData>>().apply { initDelegatesManager() }) {

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListItemSectionData>() {
        override fun areItemsTheSame(
                old: ListItemSectionData, new: ListItemSectionData): Boolean {
            return old::class.java.isInstance(new)
        }

        override fun areContentsTheSame(
                old: ListItemSectionData, new: ListItemSectionData): Boolean {
            return old == new
        }

        override fun getChangePayload(oldItem: ListItemSectionData, newItem: ListItemSectionData): Any? {
            return if (newItem is HasPayloads)
                newItem.getPayload(oldItem)
            else
                super.getChangePayload(oldItem, newItem)
        }
    }

    private val mDiffer = AsyncListDiffer(this, DIFF_CALLBACK)

    fun submitList(list: List<ListItemSectionData>) {
        setItems(list)
        mDiffer.submitList(list)
    }
}