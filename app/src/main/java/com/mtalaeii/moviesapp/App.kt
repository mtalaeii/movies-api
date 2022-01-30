package com.mtalaeii.moviesapp

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application(){
    override fun onCreate() {
        super.onCreate()
        val config = YandexMetricaConfig.newConfigBuilder("7d187f8d-63af-46ba-b7ce-4b8ae3e24c81")
            .withNativeCrashReporting(false)
            .withLocationTracking(true)
            .withAppVersion("1.0")
            .build()

        YandexMetrica.activate(this, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}