package com.mtalaeii.moviesapp

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application(){
    override fun onCreate() {
        super.onCreate()
        val config = YandexMetricaConfig.newConfigBuilder(BuildConfig.APP_METRICA_API_KEY)
            .withNativeCrashReporting(false)
            .withLocationTracking(true)
            .withAppVersion("1.0")
            .build()

        YandexMetrica.activate(this, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}