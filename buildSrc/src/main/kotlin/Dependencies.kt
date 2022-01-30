import org.gradle.api.artifacts.dsl.DependencyHandler
object BuildPlugin{
    const val androidx_navigation = "androidx.navigation.safeargs"
    const val app_mterica = "appmetrica-plugin"
    const val android_library = "com.android.library"
    const val android_application = "com.android.application"
    const val android_ = "kotlin-android"
    const val kapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val parcelize = "kotlin-parcelize"

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
    const val hilt_android_version = "2.38.1"
    const val hilt_compiler_version = "2.38.1"
    const val hilt_compiler_androidx_version = "1.0.0"
    const val hilt_viewModel_version = "1.0.0-alpha03"
    const val retrofit_version = "2.9.0"
    const val gson_converter_version = "2.9.0"
    const val okhttp_version = "3.12.0"
    const val gson_version = "2.8.6"
    const val paging_version = "3.0.0-alpha06"
    const val glide_version = "4.11.0"
    const val support_version = "1.0.0"
    const val lifecycle_version = "2.4.0"
    const val test_ext_version = "1.1.3"
    const val test_espresso_version = "3.4.0"

}
object Dependencies{
    //Default dependencies
    private const val support = "androidx.legacy:legacy-support-v4:${Versions.support_version}"
    private const val lifecycle_liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    private const val lifecycle_viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"

    private const val  navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    private const val  navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    private const val app_metrica = "com.yandex.android:mobmetricalib:${Versions.app_metrica_version}"
    private const val android_core = "androidx.core:core-ktx:${Versions.android_core_version}"
    private const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat_version}"
    private const val material = "com.google.android.material:material:${Versions.material_version}"
    private const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    //Hilt
    private const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android_version}"
    private const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt_compiler_version}"
    private const val hilt_compiler_androidx = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler_androidx_version}"
    private const val hilt_viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_viewModel_version}"
    //Retrofit
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    private const val gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.gson_converter_version}"
    private const val okhttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"
    private const val gson = "com.google.code.gson:gson:${Versions.gson_version}"
    //Paging
    private const val paging =  "androidx.paging:paging-runtime:${Versions.paging_version}"
    //Glide
    private const val glide =  "com.github.bumptech.glide:glide:${Versions.glide_version}"

    //androidTestLibraries
    private const val test_ext = "androidx.test.ext:junit:${Versions.test_ext_version}"
    private const val test_espresso = "androidx.test.espresso:espresso-core:${Versions.test_espresso_version}"

    val appLibraries = arrayListOf<String>().apply {
        add(navigation_ui)
        add(app_metrica)
        add(navigation_fragment)
        add(android_core)
        add(app_compat)
        add(material)
        add(constraint_layout)
        add(hilt_android)
        add(hilt_viewModel)
        add(retrofit)
        add(gson)
        add(gson_converter)
        add(okhttp)
        add(paging)
        add(glide)
        add(support)
        add(lifecycle_viewModel)
        add(lifecycle_liveData)
    }


    val kapt = arrayListOf<String>().apply {
        add(hilt_compiler)
        add(hilt_compiler_androidx)
    }

    val androidTestImplements = arrayListOf<String>().apply {
        add(test_ext)
        add(test_espresso)
    }

}
object GradleDependencies{
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin_version}"
    const val  build_tools = "com.android.tools.build:gradle:${Versions.build_tools_version}"
    const val app_metrica = "com.yandex.android:appmetrica-build-plugin:${Versions.app_metrica_plugin_version}"
    const val  navigation_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.nav_version}"
    const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_android_version}"

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
//fun DependencyHandler.classpath(list: List<String>){
//    list.forEach { dependency ->
//        add("classpath", dependency)
//    }
//}