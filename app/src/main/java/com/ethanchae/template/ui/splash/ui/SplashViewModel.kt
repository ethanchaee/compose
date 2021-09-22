package com.ethanchae.template.ui.splash.ui

import com.ethanchae.template.base.BaseViewModel
import com.example.domain.usecase.splash.SplashAction
import com.example.domain.usecase.splash.SplashUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val useCase: SplashUseCase
) : BaseViewModel(useCase) {
    val navigateToMain = useCase.navigateToMainState

    fun onClickNavigateToMain() {
        useCase.action(SplashAction.NextClicked)
    }
}
