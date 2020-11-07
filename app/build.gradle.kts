plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildToolsVersion)

    defaultConfig {
        applicationId = "com.shubham.marketpulse"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        multiDexEnabled = true
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://mp-android-challenge.herokuapp.com/\"")
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://mp-android-challenge.herokuapp.com/\"")
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation(Libs.kotlin)
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

    // AndroidX
    implementation(Libs.core)
    implementation(Libs.appcompat)
    implementation(Libs.multiDex)
    implementation(Libs.activity)
    implementation(Libs.fragment)
    implementation(Libs.constraintLayout)
    implementation(Libs.recyclerView)
    implementation(Libs.cardView)

    // Jetpack
    implementation(Libs.viewModel)
    implementation(Libs.liveData)
    kapt(Libs.lifecycleCompiler)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)

    // Square
    implementation(Libs.daggerCore)
    implementation(Libs.daggerAndroid)
    implementation(Libs.daggerAndroidSupport)
    kapt(Libs.daggerAndroidProcessor)
    kapt(Libs.daggerAndroidCompiler)
    implementation(Libs.retrofit)
    implementation(Libs.retrofitConverter)
    implementation(Libs.okHttp)
    implementation(Libs.okHttpLoggingInterceptor)

    // Google
    implementation(Libs.gson)
    implementation(Libs.materialDesign)

    // Testing
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.androidJunit)
    androidTestImplementation(TestLibs.androidEspresso)
}