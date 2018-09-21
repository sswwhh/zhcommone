package zhirenko.com.zhcommon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_listitems.*
import zhirenko.com.zhcommon.App
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.adapters.ListItemsAdapter
import zhirenko.com.zhcommon.delegates.EventSectionDelegate
import zhirenko.com.zhcommon.delegates.MoveSectionDelegate
import zhirenko.com.zhcommon.delegates.NoticeSectionDelegate
import zhirenko.com.zhcommon.models.Event
import zhirenko.com.zhcommon.models.Item
import zhirenko.com.zhcommon.models.Move
import zhirenko.com.zhcommon.models.Notice
import zhirenko.com.zhcommon.sections.SectionMapper
import java.util.*

class ListItemsFragments : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ((activity?.application) as App).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listitems, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupViewModel("")
    }

    private fun setupUI() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListItemsAdapter {
                // здесь делегаты для секций
                addDelegate(MoveSectionDelegate())
                addDelegate(NoticeSectionDelegate())
                addDelegate(EventSectionDelegate())
            }
        }
    }


    private fun setupViewModel(productId: String) {
        val list : List<Item> = listOf(Notice(Date(), "one"),
                Notice(Date(), "two"),
                Move("fromPlace", "toPlace", 42F),
                Event(Date(), Date(), "First event"),
                Notice(Date(), "three"),
                Event(Date(), Date(), "Second event"),
                Move("fromPlace2", "toPlace2", 43F))
        val sections = SectionMapper().mapToSections(list)
        (rv_list.adapter as ListItemsAdapter).submitList(sections)


    }

}
