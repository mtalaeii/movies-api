plugins {
    id(BuildPlugin.android_)
    id(BuildPlugin.android_application)
    id(BuildPlugin.kapt)
    id(BuildPlugin.app_mterica)
    id(BuildPlugin.androidx_navigation)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.mtalaeii.moviesapp"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
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
    appmetrica  {
        setPostApiKey( "223e4c53-169b-486d-b13a-3ff723e3dd41")
        setMappingBuildTypes(listOf())
    }
}

dependencies {
    implementation(Dependencies.appLibraries)
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    kapt(Dependencies.kapt)
    implementation(project(":login"))
    implementation(project(":core"))
    implementation(project(":search"))
    implementation(project(":main"))
}