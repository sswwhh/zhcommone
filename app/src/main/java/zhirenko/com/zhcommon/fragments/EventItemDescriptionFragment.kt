package zhirenko.com.zhcommon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_event.*
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.models.Event

class EventItemDescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val event = (arguments?.getSerializable("event") as Event?) ?: return

        tv_start.text = event.startTime.toString()
        tv_end.text = event.endTime.toString()
        tv_name.text = event.name

    }

    companion object {
        fun getInstance(bundle : Bundle): EventItemDescriptionFragment {
            val fragment = EventItemDescriptionFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}