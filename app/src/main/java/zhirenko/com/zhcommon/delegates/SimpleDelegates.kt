package zhirenko.com.zhcommon.delegates

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate

abstract class SimpleDelegate<T> : AdapterDelegate<List<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.view())
    }

    override fun isForViewType(items: List<T>, position: Int) = forViewType(items[position])

    override fun onBindViewHolder(items: List<T>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        holder.itemView.bindView(items[position], holder, payloads)
    }

    abstract fun ViewGroup.view(): View

    abstract fun forViewType(item: T): Boolean

    abstract fun View.bindView(item: T, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>)

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

}