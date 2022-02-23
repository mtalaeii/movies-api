plugins {
    id(BuildPlugin.android_library)
    id(BuildPlugin.android_)
    id(BuildPlugin.kapt)
    id(BuildPlugin.hilt)
    id(BuildPlugin.parcelize)
    id(BuildPlugin.androidx_navigation)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName(AppConfig.BuildTypes.release) {
            isMinifyEnabled = false
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility (JavaVersion.VERSION_11)
        targetCompatibility (JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation(Dependencies.appLibraries)
    testImplementation (Dependencies.testImplements)
    androidTestImplementation (Dependencies.androidTestImplements)
    kapt(Dependencies.kapt)
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")
    debugImplementation ("androidx.fragment:fragment-testing:1.5.0-alpha01")
    annotationProcessor("androidx.room:room-compiler:${Versions.room_version}")
    implementation(project(":core"))

}