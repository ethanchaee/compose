package com.example.data.common

import android.content.Intent
import android.os.Bundle

typealias RequestCode = Int
typealias ResultCode = Int

sealed class LifecycleState {
    data class OnCreate(val savedInstanceState: Bundle?) : LifecycleState()

    class OnStart : LifecycleState()

    class OnResume : LifecycleState()

    class OnPause : LifecycleState()

    class OnStop : LifecycleState()

    class OnDestroy : LifecycleState()

    data class OnActivityResult(val requestCode: RequestCode, val resultCode: ResultCode, val data: Intent?) : LifecycleState()
}
