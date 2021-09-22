object Apps {
    const val compileSdk = 30
    const val minSdk = 24
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "7.0.1"
    const val kotlin = "1.5.21"
    const val coroutines = "1.5.1"
    const val junit = "4.13.2"
    const val timber = "4.7.1"

    object Google {
        object Jetpack {
            const val appcompat = "1.3.1"
            const val fragment = "1.3.6"
            const val recyclerview = "1.2.1"
            const val annotation = "1.2.0"
            const val constraintLayout = "2.0.4"
            const val lifecycle = "2.2.0"
            const val room = "2.3.0"
            const val paging = "3.0.1"
            const val core = "1.6.0"
            const val navigation = "2.3.5"
            const val preference = "1.1.1"
            const val transition = "1.4.1"
            const val security = "1.1.0-alpha03"
        }

        object Dagger {
            const val dagger = "2.38.1"
            const val hilt = "1.0.0"
        }

        const val material = "1.4.0"
    }

    object Square {
        const val retrofit = "2.9.0"
        const val okhttp = "4.9.0"
    }

    object Facebook {
        const val stetho = "1.5.1"
    }

    object Rx {
        const val rxJava = "3.0.9"
        const val rxKotlin = "3.0.1"
        const val rxAndroid = "3.0.0"
        const val rxRelay = "3.0.0"
    }

    object Test {
        const val junit = "4.13"
        const val mockito = "3.5.6"
        const val archTesting = "2.1.0"
        const val robolectric = "4.5.1"
        const val truth = "1.0.1"
    }

    const val ktlint = "0.40.0"
    const val detekt = "1.15.0"
}