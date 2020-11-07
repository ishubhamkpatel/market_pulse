object Apps {
    const val compileSdk = 29
    const val buildToolsVersion = "29.0.3"
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "4.0.2"

    /* kotlin */
    const val kotlin = "1.4.0"
    const val coroutines = "1.4.1"

    /* androidX */
    const val core = "1.3.2"
    const val appcompat = "1.2.0"
    const val multiDex = "2.0.1"
    const val activity = "1.1.0"
    const val fragment = "1.2.5"
    const val constraintLayout = "2.0.4"
    const val recyclerView = "1.1.0"
    const val cardView = "1.0.0"

    /* jetpack */
    const val lifecycle = "2.2.0"
    const val navigation = "2.3.1"

    /* square */
    const val dagger = "2.29.1"
    const val retrofit = "2.9.0"
    const val okHttp = "4.9.0"

    /* google */
    const val gson = "2.8.6"
    const val materialDesign = "1.2.1"

    /* test */
    const val junit = "4.12"
    const val androidJunit = "1.1.2"
    const val androidEspresso = "3.3.0"
}

object Libs {
    /* kotlin */
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    /* androidX */
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"

    /* jetpack */
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    /* square */
    const val dagger = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"

    /* google */
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val androidEspresso = "androidx.test.espresso:espresso-core:${Versions.androidEspresso}"
}

object BuildToolsPlugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}