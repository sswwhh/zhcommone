package zhirenko.com.zhcommon.di

import android.support.v4.app.Fragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: Fragment)
}