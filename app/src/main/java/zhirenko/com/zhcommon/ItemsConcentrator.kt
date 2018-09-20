package zhirenko.com.zhcommon

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class ItemsConcentrator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_empty)
//
//        if (intent.data != null && intent.data.path != null) {
//            parseProductId(intent.data.path)?.let { productId ->
//                intent.putExtra(ARG_ID_PRODUCT, productId)
//                sendProductDeeplinkAnalytics(intent.data)
//            }
//        }
//
//        fgm = ItemsFragment.getInstance(intent.extras)

//        supportFragmentManager.beginTransaction().replace(R.id.container, fgm).commit()
    }

}