package zhirenko.com.zhcommon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import zhirenko.com.zhcommon.fragments.ListItemsFragments

class ItemsConcentrator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        val fgm = ListItemsFragments()
        startFragment(fgm)
    }

    fun startFragment(fragment: Fragment,
                      addToBackStack: Boolean = true) {

        if (addToBackStack) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(fragment.javaClass.name)
                    .commit()
        } else {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
        }
    }

}