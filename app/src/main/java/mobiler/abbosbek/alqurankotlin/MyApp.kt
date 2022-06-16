package mobiler.abbosbek.alqurankotlin

import android.app.Application
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.orhanobut.hawk.Hawk
import mobiler.abbosbek.alqurankotlin.db.AppDatabase

class MyApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)
        Hawk.init(this).build()
        AppDatabase.initDatabase(this)
    }
}