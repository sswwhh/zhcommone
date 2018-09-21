package zhirenko.com.zhcommon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_notice.*
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.models.Notice

class NoticeItemDescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_notice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notice = (arguments?.getSerializable("notice") as Notice?) ?: return

        tv_date.text = notice.flightDate.toString()
        tv_gate.text = notice.gate
    }

    companion object {
        fun getInstance(bundle : Bundle): NoticeItemDescriptionFragment {
            val fragment = NoticeItemDescriptionFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}