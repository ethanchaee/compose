package com.ethanchae.template.ui.activity

import com.ethanchae.template.base.BaseViewModel
import com.example.domain.usecase.activity.MainActivityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    mainActivityUseCase: MainActivityUseCase,
) : BaseViewModel(mainActivityUseCase)
