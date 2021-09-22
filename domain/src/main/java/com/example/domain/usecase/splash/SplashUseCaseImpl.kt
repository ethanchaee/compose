package com.example.domain.usecase.splash

import com.example.base.lifecycle.LiveEvent
import com.example.data.common.NavigationState
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor() : SplashUseCase() {

    override val navigateToMainState = LiveEvent<NavigationState.NavigateToMain>()

    override fun initUseCase() {
        super.initUseCase()
        navigateToMainCase().bind(navigateToMainState)
    }

    override fun navigateToMainCase(): Observable<NavigationState.NavigateToMain> = action<SplashAction.NextClicked>()
        .map { NavigationState.NavigateToMain }
}
