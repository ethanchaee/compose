plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

apply {
    from("../teamConfig/staticCodeAnalysis/ktlint.gradle")
    from("../teamConfig/staticCodeAnalysis/detekt.gradle")
}

kapt {
    correctErrorTypes = true
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
        implementation(project(":base"))

        implementation(Libs.Kotlin.stdLib)

        implementation(Libs.Google.Jetpack.annotation)
        implementation(Libs.Google.Jetpack.lifecycleExtensions)
        implementation(Libs.Google.Jetpack.lifecycleViewModelKtx)
        implementation(Libs.Google.Jetpack.lifecycleCommonJava8)
        implementation(Libs.Google.Jetpack.core)
        implementation(Libs.Google.Jetpack.coreKtx)

        implementation(Libs.Google.Dagger.dagger)
        kapt(Libs.Google.Dagger.daggerCompiler)
        implementation(Libs.Google.Dagger.hiltAndroid)
        kapt(Libs.Google.Dagger.hiltAndroidCompiler)
        implementation(Libs.Google.Dagger.hiltCommon)
        kapt(Libs.Google.Dagger.hiltCompiler)

        implementation(Libs.Rx.rxJava)
        implementation(Libs.Rx.rxKotlin)
        implementation(Libs.Rx.rxAndroid)
        implementation(Libs.Rx.rxRelay)

        implementation(Libs.Stetho.stetho)
        implementation(Libs.Stetho.stethoOkhttp)

        implementation(Libs.Square.retrofit)
        implementation(Libs.Square.retrofitGsonConverter)
        implementation(Libs.Square.retroftRxJava3Adapter)

        testImplementation(Libs.Test.junit)
        testImplementation(Libs.Test.roomTesting)
        testImplementation(Libs.Test.coroutines)
        testImplementation(Libs.Test.coroutinesTest)
        testImplementation(Libs.Test.arcTesting)
        testImplementation(Libs.Test.mockitoCore)
        testImplementation(Libs.Test.mockitoInline)
        testImplementation(Libs.Test.robolectric)
        testImplementation(Libs.Test.truth)
        testImplementation(Libs.Square.retrofit)

        implementation(Libs.timber)
    }
}