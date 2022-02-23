plugins {
    id(BuildPlugin.android_)
    id(BuildPlugin.android_application)
    id(BuildPlugin.kapt)
    id(BuildPlugin.app_mterica)
    id(BuildPlugin.androidx_navigation)
    id(BuildPlugin.hilt)
    id(BuildPlugin.parcelize)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.mtalaeii.moviesapp"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        buildConfigField("String","APP_METRICA_API_KEY",properties["APP_METRICA_API_KEY"].toString())
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
        sourceCompatibility (JavaVersion.VERSION_11)
        targetCompatibility (JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures{
        dataBinding = true
    }
    appmetrica  {
        setPostApiKey( "223e4c53-169b-486d-b13a-3ff723e3dd41")
        setMappingBuildTypes(listOf())
    }
    packagingOptions {
        jniLibs.excludes.add("META-INF/*.kotlin_module")
        jniLibs.excludes.add("win32-x86/attach_hotspot_windows.dll")
        jniLibs.excludes.add("win32-x86-64/attach_hotspot_windows.dll")
        jniLibs.excludes.add("META-INF/licenses/**")
        jniLibs.excludes.add("META-INF/AL2.0")
        jniLibs.excludes.add("META-INF/LGPL2.1")
        jniLibs.excludes.add("META-INF/DEPENDENCIES")
        jniLibs.excludes.add("META-INF/LICENSE")
        jniLibs.excludes.add("META-INF/LICENSE.txt")
        jniLibs.excludes.add("META-INF/license.txt")
        jniLibs.excludes.add("META-INF/LICENSE.md")
        jniLibs.excludes.add("META-INF/LICENSE-notice.md")
    }
    testOptions {
        unitTests{
            isReturnDefaultValues=true
        }
    }
}

dependencies {
    implementation(Dependencies.appLibraries)
    testImplementation (Dependencies.testImplements)
    androidTestImplementation (Dependencies.androidTestImplements)
    kapt(Dependencies.kapt)
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")
    debugImplementation ("androidx.fragment:fragment-testing:1.5.0-alpha01")
    implementation(project(":login"))
    implementation(project(":core"))
    implementation(project(":search"))
    implementation(project(":main"))
    implementation(project(":favorites"))
}