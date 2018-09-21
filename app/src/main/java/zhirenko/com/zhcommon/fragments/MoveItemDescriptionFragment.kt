package zhirenko.com.zhcommon.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_move.*
import zhirenko.com.zhcommon.R
import zhirenko.com.zhcommon.models.Move

class MoveItemDescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_move, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val move = (arguments?.getSerializable("move") as Move?) ?: return

        tv_from.text = move.fromPlace
        tv_to.text = move.toPlace
        tv_estimate.text = move.estimateTime.toString()
    }

    companion object {
        fun getInstance(bundle : Bundle): MoveItemDescriptionFragment {
            val fragment = MoveItemDescriptionFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}