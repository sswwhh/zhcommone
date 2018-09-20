package zhirenko.com.zhcommon

import android.app.ActivityManager
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate
import android.util.Log
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import zhirenko.com.zhcommon.di.AppComponent
import zhirenko.com.zhcommon.di.AppModule
import zhirenko.com.zhcommon.di.DaggerAppComponent

class App : MultiDexApplication() {


    private lateinit var instance: Context
    private lateinit var appComponent: AppComponent


    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)

        instance = context
        buildComponent()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onCreate() {
        super.onCreate()

        initPicasso()
    }



    fun buildComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(instance))
                .build()
    }


    private fun initPicasso() {
        val PICASSO_CACHE_SIZE = 200 * 150 * 1024
        val cache = Cache(cacheDir, PICASSO_CACHE_SIZE.toLong())
        val client = OkHttpClient.Builder().cache(cache).build()
        val picassoBuilder = Picasso.Builder(this)
                .listener { picasso, uri, exception -> if (BuildConfig.DEBUG) exception.printStackTrace() }
                .downloader(OkHttp3Downloader(client))

        if (isLowMemoryDevice()) {
            picassoBuilder.defaultBitmapConfig(Bitmap.Config.RGB_565)
        }
        Log.d("Tag:App", "onCreate: " + isLowMemoryDevice())
        val picasso = picassoBuilder
                .build()
        Picasso.setSingletonInstance(picasso)
    }


    private fun isLowMemoryDevice(): Boolean {
        return Build.VERSION.SDK_INT >= 19 && (getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)
                .isLowRamDevice
    }
}