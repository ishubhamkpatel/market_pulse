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
    const val kotlin = "1.4.0"
    const val core = "1.3.2"
    const val appcompat = "1.2.0"

    const val constraintLayout = "2.0.4"

    /* test */
    const val junit = "4.12"
    const val androidJunit = "1.1.2"
    const val androidEspresso = "3.3.0"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val androidEspresso = "androidx.test.espresso:espresso-core:${Versions.androidEspresso}"
}