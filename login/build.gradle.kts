plugins {
    id(BuildPlugin.android_library)
    id(BuildPlugin.android_)
    id(BuildPlugin.kapt)
    id(BuildPlugin.androidx_navigation)
    id(BuildPlugin.hilt)
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
        sourceCompatibility (JavaVersion.VERSION_11)
        targetCompatibility (JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation(Dependencies.appLibraries)
    kapt(Dependencies.kapt)
    testImplementation ("junit:junit:4.+" )
    androidTestImplementation (Dependencies.androidTestImplements)
    implementation(project(":core"))
}