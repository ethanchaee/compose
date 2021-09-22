plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

apply {
    from("../teamConfig/staticCodeAnalysis/ktlint.gradle")
    from("../teamConfig/staticCodeAnalysis/detekt.gradle")
    from("../teamConfig/git/git-hooks.gradle")
}

kapt {
    correctErrorTypes = true
}

android {
    signingConfigs {
        create("ide") {
            storeFile = file("../keystore/debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }
    compileSdk = Apps.compileSdk
    defaultConfig {
        applicationId = "com.ethanchae.template"
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("ide")
            applicationIdSuffix = ".debug"

            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            isCrunchPngs = true

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dataBinding {
        isEnabled = true
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
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":base"))

    implementation(Libs.Kotlin.stdLib)
    implementation(Libs.Kotlin.coroutines)

    kapt(Libs.Google.Jetpack.databindingCompiler)
    implementation(Libs.Google.Jetpack.appcompat)
    implementation(Libs.Google.Jetpack.material)
    implementation(Libs.Google.Jetpack.fragment)
    implementation(Libs.Google.Jetpack.fragmentKtx)
    implementation(Libs.Google.Jetpack.recyclerview)
    implementation(Libs.Google.Jetpack.annotation)
    implementation(Libs.Google.Jetpack.transition)
    implementation(Libs.Google.Jetpack.constraintLayout)
    implementation(Libs.Google.Jetpack.lifecycleExtensions)
    implementation(Libs.Google.Jetpack.lifecycleViewModelKtx)
    implementation(Libs.Google.Jetpack.lifecycleCommonJava8)
    implementation(Libs.Google.Jetpack.paging)
    implementation(Libs.Google.Jetpack.pagingRxJava3)
    implementation(Libs.Google.Jetpack.room)
    implementation(Libs.Google.Jetpack.roomRxJava3)
    kapt(Libs.Google.Jetpack.roomCompiler)
    implementation(Libs.Google.Jetpack.coreKtx)
    implementation(Libs.Google.Jetpack.core)
    implementation(Libs.Google.Jetpack.preference)
    implementation(Libs.Google.Jetpack.preferenceKtx)
    implementation(Libs.Google.Jetpack.security)
    implementation(Libs.Google.Jetpack.navigationFragment)
    implementation(Libs.Google.Jetpack.navigationUiKtx)

    implementation(Libs.Rx.rxJava)
    implementation(Libs.Rx.rxKotlin)
    implementation(Libs.Rx.rxAndroid)
    implementation(Libs.Rx.rxRelay)

    implementation(Libs.Google.Dagger.dagger)
    kapt(Libs.Google.Dagger.daggerCompiler)
    implementation(Libs.Google.Dagger.hiltAndroid)
    kapt(Libs.Google.Dagger.hiltAndroidCompiler)
    implementation(Libs.Google.Dagger.hiltCommon)
    kapt(Libs.Google.Dagger.hiltCompiler)

    implementation(Libs.Stetho.stetho)
    implementation(Libs.Stetho.stethoOkhttp)

    implementation(Libs.Square.retrofit)
    implementation(Libs.Square.retrofitGsonConverter)
    implementation(Libs.Square.retroftRxJava3Adapter)
    implementation(Libs.Square.okhttp)
    implementation(Libs.Square.okhttpLoggingIterceptor)

    testImplementation(Libs.Test.junit)
    testImplementation(Libs.Test.coroutines)
    testImplementation(Libs.Test.coroutinesTest)
    testImplementation(Libs.Test.arcTesting)
    testImplementation(Libs.Test.roomTesting)
    testImplementation(Libs.Test.mockitoCore)
    testImplementation(Libs.Test.mockitoInline)
    testImplementation(Libs.Test.robolectric)
    testImplementation(Libs.Test.truth)
    testImplementation(Libs.Test.mockWebServer)
    testImplementation(Libs.Test.hiltAndroidTesting)
    testImplementation(Libs.Test.daggerCompiler)
    testImplementation(Libs.Test.hiltCompiler)
    testImplementation(Libs.Test.hiltAndroidCompiler)

    implementation(Libs.timber)
}