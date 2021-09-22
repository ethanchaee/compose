package com.ethanchae.template.base

import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.data.common.LifecycleState
import com.example.domain.BaseUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel(
    private vararg val useCases: BaseUseCase<*>,
) : ViewModel() {

    init {
        useCases.forEach { it.initUseCase() }
    }
    protected val compositeDisposable: CompositeDisposable by lazy(LazyThreadSafetyMode.NONE) {
        CompositeDisposable()
    }

    fun bindFragment(fragment: Fragment) {
        fragment
    }

    fun lifecycle(lifecycleState: LifecycleState) {
        useCases.forEach {
            it.lifecycle(lifecycleState)
        }
    }

    @CallSuper
    override fun onCleared() {
        compositeDisposable.clear()

        useCases.forEach {
            it.onCleared()
        }

        super.onCleared()
    }
}
