package zhirenko.com.zhcommon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_listitems.*
import zhirenko.com.zhcommon.Ext.random
import zhirenko.com.zhcommon.ItemsConcentrator
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.adapters.ListItemSectionData
import zhirenko.com.zhcommon.adapters.ListItemsAdapter
import zhirenko.com.zhcommon.delegates.EventSectionDelegate
import zhirenko.com.zhcommon.delegates.MoveSectionDelegate
import zhirenko.com.zhcommon.delegates.NoticeSectionDelegate
import zhirenko.com.zhcommon.mappers.mapToEvent
import zhirenko.com.zhcommon.mappers.mapToMove
import zhirenko.com.zhcommon.mappers.mapToNotice
import zhirenko.com.zhcommon.models.Item
import zhirenko.com.zhcommon.models.ItemFactory
import zhirenko.com.zhcommon.models.Items
import zhirenko.com.zhcommon.sections.EventSection
import zhirenko.com.zhcommon.sections.MoveSection
import zhirenko.com.zhcommon.sections.NoticeSection
import zhirenko.com.zhcommon.sections.SectionMapper

class ListItemsFragments : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //((activity?.application) as App).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_listitems, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupList()
    }

    private fun setupUI() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListItemsAdapter {
                // здесь делегаты для секций
                addDelegate(MoveSectionDelegate { item -> onSectionItemClicked(item) })
                addDelegate(NoticeSectionDelegate { item -> onSectionItemClicked(item) })
                addDelegate(EventSectionDelegate { item -> onSectionItemClicked(item) })
            }
        }
    }

    private fun onSectionItemClicked(item: ListItemSectionData) {
        when(item) {
            is MoveSection -> {
                val bundle = Bundle()
                bundle.putSerializable("move", item.mapToMove())
                (activity as ItemsConcentrator).startFragment(MoveItemDescriptionFragment.getInstance(bundle))
            }
            is EventSection -> {
                val bundle = Bundle()
                bundle.putSerializable("event", item.mapToEvent())
                (activity as ItemsConcentrator).startFragment(EventItemDescriptionFragment.getInstance(bundle))
            }
            is NoticeSection -> {
                val bundle = Bundle()
                bundle.putSerializable("notice", item.mapToNotice())
                (activity as ItemsConcentrator).startFragment(NoticeItemDescriptionFragment.getInstance(bundle))
            }
            else -> Toast.makeText(activity, "else", Toast.LENGTH_SHORT).show()
        }
    }


    // use dagger to inject list
    private fun setupList() {
        val items : MutableList<Item> = arrayListOf()

        val times = (10..100).random()
        for (i in 0..times){
            items.add(ItemFactory.getItem(Items.randomItem()))
        }

        val sections = SectionMapper().mapToSections(items)
        (rv_list.adapter as ListItemsAdapter).submitList(sections)
    }

}
