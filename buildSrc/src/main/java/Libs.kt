object Libs {
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Google {
        object Jetpack {
            const val databindingCompiler = "androidx.databinding:databinding-compiler:${Versions.gradle}"
            const val appcompat = "androidx.appcompat:appcompat:${Versions.Google.Jetpack.appcompat}"
            const val material = "com.google.android.material:material:${Versions.Google.material}"
            const val fragment = "androidx.fragment:fragment:${Versions.Google.Jetpack.fragment}"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.Google.Jetpack.fragment}"
            const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.Google.Jetpack.recyclerview}"
            const val annotation = "androidx.annotation:annotation:${Versions.Google.Jetpack.annotation}"
            const val transition = "androidx.transition:transition:${Versions.Google.Jetpack.transition}"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.Google.Jetpack.constraintLayout}"
            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.Google.Jetpack.lifecycle}"
            const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Google.Jetpack.lifecycle}"
            const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.Google.Jetpack.lifecycle}"
            const val paging = "androidx.paging:paging-runtime:${Versions.Google.Jetpack.paging}"
            const val pagingRxJava3 = "androidx.paging:paging-rxjava3:${Versions.Google.Jetpack.paging}"
            const val room = "androidx.room:room-runtime:${Versions.Google.Jetpack.room}"
            const val roomRxJava3 = "androidx.room:room-rxjava3:${Versions.Google.Jetpack.room}"
            const val roomCompiler = "androidx.room:room-compiler:${Versions.Google.Jetpack.room}"
            const val coreKtx = "androidx.core:core-ktx:${Versions.Google.Jetpack.core}"
            const val core = "androidx.core:core:${Versions.Google.Jetpack.core}"
            const val preference = "androidx.preference:preference:${Versions.Google.Jetpack.preference}"
            const val preferenceKtx = "androidx.preference:preference:${Versions.Google.Jetpack.preference}"
            const val security = "androidx.security:security-crypto:${Versions.Google.Jetpack.security}"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.Google.Jetpack.navigation}"
            const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.Google.Jetpack.navigation}"
        }

        object Dagger {
            const val dagger = "com.google.dagger:dagger:${Versions.Google.Dagger.dagger}"
            const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.Google.Dagger.dagger}"
            const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Google.Dagger.dagger}"
            const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.Google.Dagger.dagger}"
            const val hiltCommon = "androidx.hilt:hilt-common:${Versions.Google.Dagger.hilt}"
            const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.Google.Dagger.hilt}"
        }
    }

    object Rx {
        const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.Rx.rxJava}"
        const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.Rx.rxKotlin}"
        const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.Rx.rxAndroid}"
        const val rxRelay = "com.jakewharton.rxrelay3:rxrelay:${Versions.Rx.rxRelay}"
    }

    object Stetho {
        const val stetho = "com.facebook.stetho:stetho:${Versions.Facebook.stetho}"
        const val stethoOkhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.Facebook.stetho}"
    }

    object Square {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Square.retrofit}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.Square.retrofit}"
        const val retroftRxJava3Adapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.Square.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Square.okhttp}"
        const val okhttpLoggingIterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Square.okhttp}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val arcTesting = "androidx.arch.core:core-testing:${Versions.Test.archTesting}"
        const val roomTesting = "androidx.room:room-testing:${Versions.Google.Jetpack.room}"
        const val mockitoCore = "org.mockito:mockito-core:${Versions.Test.mockito}"
        const val mockitoInline = "org.mockito:mockito-inline:${Versions.Test.mockito}"
        const val robolectric = "org.robolectric:robolectric:${Versions.Test.robolectric}"
        const val truth = "com.google.truth:truth:${Versions.Test.truth}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.Square.okhttp}"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.Google.Dagger.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.Google.Dagger.dagger}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.Google.Dagger.hilt}"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Google.Dagger.dagger}"
    }

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}