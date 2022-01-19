import org.gradle.api.artifacts.dsl.DependencyHandler
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
    const val app_metrica_plugin_version = "0.2.4"
    const val build_tools_version = "7.0.4"
    const val app_metrica_version = "3.15.0"
    const val kotlin_gradle_plugin_version = "1.6.10"
    const val android_core_version = "1.7.0"
    const val app_compat_version = "1.4.1"
    const val material_version = "1.5.0"
    const val constraint_layout_version = "2.1.3"
}
object Dependencies{
    private const val  navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    private const val  navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    private const val app_metrica = "com.yandex.android:mobmetricalib:${Versions.app_metrica_version}"
    private const val android_core = "androidx.core:core-ktx:${Versions.android_core_version}"
    private const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat_version}"
    private const val material = "com.google.android.material:material:${Versions.material_version}"
    private const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    val appLibraries = arrayListOf<String>().apply {
        add(navigation_ui)
        add(app_metrica)
        add(navigation_fragment)
        add(android_core)
        add(app_compat)
        add(material)
        add(constraint_layout)
    }

//    val kapt = arrayListOf<String>().apply {
//        add(hiltAndroidCompiler)
//        add(hiltAndroidKaptCompiler)
//        add(hiltCompiler)
//    }
//
//    val mainModuleKapt = arrayListOf<String>().apply {
//        add(navigationFragment)
//        add(hiltAndroidCompiler)
//    }
//
//    val mainLibraries = arrayListOf<String>().apply {
//        add(kotlinStdLib)
//        add(coreKtx)
//        add(appcompat)
//        add(constraintLayout)
//        add(material)
//        add(navigationFragment)
//        add(navigationUi)
//        add(junit)
//        add(extJUnit)
//        add(espressoCore)
//        add(hiltAndroid)
//        add(loggingInterceptor)
//        add(retrofit)
//        add(retrofitGson)
//        add(glide)
//        add(coroutinesCore)
//        add(lifecycleArch)
//    }
//    val dataLibraries = arrayListOf<String>().apply {
//        add(kotlinStdLib)
//        add(coreKtx)
//        add(appcompat)
//        add(junit)
//        add(extJUnit)
//        add(espressoCore)
//        add(retrofit)
//        add(hiltAndroid)
//        add(retrofitGson)
//        add(loggingInterceptor)
//    }
//
//    val domainLibraries = arrayListOf<String>().apply {
//        add(kotlinStdLib)
//        add(coreKtx)
//        add(appcompat)
//        add(junit)
//        add(extJUnit)
//        add(espressoCore)
//        add(retrofit)
//        add(hiltAndroid)
//        add(retrofit)
//    }
}
object GradleDependencies{
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin_version}"
    const val  build_tools = "com.android.tools.build:gradle:${Versions.build_tools_version}"
    const val app_metrica = "com.yandex.android:appmetrica-build-plugin:${Versions.app_metrica_plugin_version}"
    const val  navigation_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"

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


//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.modules(list: List<String>) {
    list.forEach { dependency ->
        add("implementation",project(mapOf("path" to dependency)))
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}