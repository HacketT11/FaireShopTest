package com.faire.faireshop

import android.app.Application
import com.faire.faireshop.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class FaireApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FaireApp)
            modules(mainModule)
        }
    }
}