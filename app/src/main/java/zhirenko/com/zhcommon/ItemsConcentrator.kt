package zhirenko.com.zhcommon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import zhirenko.com.zhcommon.fragments.ListItemsFragments

class ItemsConcentrator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        val fgm = ListItemsFragments()
        supportFragmentManager.beginTransaction().replace(R.id.container, fgm).commit()
    }

}