package com.example.domain

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import com.example.base.subscribeOf
import com.example.data.common.LifecycleState
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.ofType
import timber.log.Timber

abstract class BaseUseCase<ACTION : Any> {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val lifecycleStateRelay = PublishRelay.create<LifecycleState>()
    private val actionRelay = PublishRelay.create<ACTION>()

    private val className = this::class.simpleName

    @CallSuper
    open fun initUseCase() {
    }

    fun <T : Any> Observable<T>.bind(state: MutableLiveData<T>) {
        compositeDisposable.add(this.subscribeOf(onNext = { state.postValue(it) }))
    }

    fun <T : Any> Observable<T>.bind() {
        compositeDisposable.add(this.subscribeOf())
    }

    fun action(action: ACTION) {
        actionRelay.accept(action)

        Timber.d("$className Action : $action")
    }

    internal inline fun <reified A : ACTION> action(): Observable<A> = actionRelay.ofType()

    fun lifecycle(lifecycleState: LifecycleState) {
        lifecycleStateRelay.accept(lifecycleState)

        Timber.d("$className Lifecycle : $lifecycleState")
    }

    fun lifecycle(): Observable<LifecycleState> = lifecycleStateRelay

    internal inline fun <reified L : LifecycleState> lifecycle(): Observable<L> = lifecycleStateRelay.ofType()

    fun onCleared() {
        compositeDisposable.clear()
    }
}
