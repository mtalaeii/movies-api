plugins {
    id(BuildPlugin.android_library)
    id(BuildPlugin.android_)
    id(BuildPlugin.kapt)
//    id(BuildPlugin.hilt)
    id(BuildPlugin.parcelize)
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
//        consumerProguardFiles "consumer-rules.pro"
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
        sourceCompatibility (JavaVersion.VERSION_1_8)
        targetCompatibility (JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation(Dependencies.appLibraries)
    testImplementation ("junit:junit:4.+")
    androidTestImplementation (Dependencies.androidTestImplements)
    implementation(project(":core"))
}