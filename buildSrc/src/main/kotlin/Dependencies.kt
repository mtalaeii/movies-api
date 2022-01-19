//import org.gradle.api.artifacts.dsl.DependencyHandler
object BuildPlugin{
    const val androidx_navigation = "androidx.navigation.safeargs"
    const val app_mterica = "appmetrica-plugin"
    const val android_library = "com.android.library"
    const val android_application = "com.android.application"
    const val android_ = "kotlin-android"
    const val kapt = "kotlin-kapt"
}
object Versions{
    const val nav_version = "2.3.5"
    const val app_metrica_plugin_version = "3.15.0"
    const val build_tools_version = "7.0.4"
    const val app_metrica_version = "1.6.10"
    const val kotlin_gradle_plugin_version = "0.2.4"
}
object Dependencies{
    const val  navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val  navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    const val  navigation_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"
    const val app_mtrica = "com.yandex.android:mobmetricalib:${Versions.app_metrica_version}"
}
object GradleDependencies{
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin_version}"
    const val  build_tools = "com.android.tools.build:gradle:${Versions.build_tools_version}"
    const val app_metrica = "com.yandex.android:mobmetricalib:${Versions.app_metrica_plugin_version}"
}
object AppConfig {
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val  versionName : String = "1.0"
    const val buildToolsVersion = "30.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
//    const val proguardConsumerRules = "consumer-rules.pro"
//    const val dimension = "environment"

    object BuildTypes {
        const val release = "release"
        const val debug = "debug"
    }

    object ProductFlavors {
        const val staging = "staging"
        const val production = "production"
    }
}
