package com.example.domain.usecase.splash

import com.example.base.lifecycle.LiveEvent
import com.example.data.common.NavigationState
import com.example.domain.BaseUseCase
import io.reactivex.rxjava3.core.Observable

abstract class SplashUseCase : BaseUseCase<SplashAction>() {
    abstract val navigateToMainState: LiveEvent<NavigationState.NavigateToMain>

    abstract fun navigateToMainCase(): Observable<NavigationState.NavigateToMain>
}
