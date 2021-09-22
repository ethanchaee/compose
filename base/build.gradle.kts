plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply {
    from("../teamConfig/staticCodeAnalysis/ktlint.gradle")
    from("../teamConfig/staticCodeAnalysis/detekt.gradle")
}

android {
    compileSdk = Apps.compileSdk
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        kotlinOptions {
            jvmTarget = "11"
        }
    }


    dependencies {

        implementation(Libs.Kotlin.stdLib)
        implementation(Libs.Kotlin.coroutines)

        implementation(Libs.Google.Jetpack.lifecycleExtensions)
        implementation(Libs.Google.Jetpack.lifecycleCommonJava8)
        implementation(Libs.Google.Jetpack.core)
        implementation(Libs.Google.Jetpack.coreKtx)

        implementation(Libs.Rx.rxJava)
        implementation(Libs.Rx.rxKotlin)
        implementation(Libs.Rx.rxAndroid)
        implementation(Libs.Rx.rxRelay)

        implementation(Libs.timber)
    }
}