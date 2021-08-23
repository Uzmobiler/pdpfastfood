package uz.mobiler.pdpfastfood

import android.app.Application
import uz.mobiler.pdpfastfood.di.component.ApplicationComponent
import uz.mobiler.pdpfastfood.di.component.DaggerApplicationComponent
import uz.mobiler.pdpfastfood.di.module.NetworkModule

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    companion object {
        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        applicationComponent = DaggerApplicationComponent
            .builder()
            .networkModule(NetworkModule(applicationContext))
            .build()
    }
}