package com.ethanchae.template.utils

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.annotations.CheckReturnValue
import io.reactivex.rxjava3.annotations.SchedulerSupport
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.Observables
import io.reactivex.rxjava3.kotlin.withLatestFrom
import timber.log.Timber
import java.util.concurrent.TimeUnit

const val THROTTLE_CLICK_WINDOW_DURATION = 1000L

private val onNextStub: (Any) -> Unit = {}
private val onSuccessStub: (Any) -> Unit = {}
private val onCompleteStub: () -> Unit = {}
private val onErrorStub: (Throwable) -> Unit = {
    Timber.e("Rx Error - $it")

    throw it
}

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Flowable<T>.subscribeOf(
    onNext: (T) -> Unit = onNextStub,
    onError: (Throwable) -> Unit = onErrorStub,
    onComplete: () -> Unit = onCompleteStub

): Disposable = subscribe(onNext, onError, onComplete)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Observable<T>.subscribeOf(
    onNext: (T) -> Unit = onNextStub,
    onError: (Throwable) -> Unit = onErrorStub,
    onComplete: () -> Unit = onCompleteStub

): Disposable = subscribe(onNext, onError, onComplete)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Single<T>.subscribeOf(
    onSuccess: (T) -> Unit = onSuccessStub,
    onError: (Throwable) -> Unit = onErrorStub

): Disposable = subscribe(onSuccess, onError)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T : Any> Maybe<T>.subscribeOf(
    onSuccess: (T) -> Unit = onSuccessStub,
    onError: (Throwable) -> Unit = onErrorStub,
    onComplete: () -> Unit = onCompleteStub
): Disposable = subscribe(onSuccess, onError, onComplete)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun Completable.subscribeOf(
    onComplete: () -> Unit = onCompleteStub,
    onError: (Throwable) -> Unit = onErrorStub
): Disposable = subscribe(onComplete, onError)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T, U> Observable<T>.withLatestFromFirst(other: ObservableSource<U>): Observable<T> = withLatestFrom(other, { t, _ -> t })

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T, U> Observable<T>.withLatestFromSecond(other: ObservableSource<U>): Observable<U> = withLatestFrom(other, { _, u -> u })

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T, U> Observable<T>.withLiveData(liveData: LiveData<U>): Observable<Pair<T, U>> = this.filter { liveData.value != null }.map { it to liveData.value!! }

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T, U> Observable<T>.castLiveData(liveData: LiveData<U>): Observable<U> = this.withLiveData(liveData).map { it.second }

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.COMPUTATION)
fun <T> Observable<T>.throttleClick(throttleDelay: Long = THROTTLE_CLICK_WINDOW_DURATION): Observable<T> = throttleFirst(throttleDelay, TimeUnit.MILLISECONDS)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.COMPUTATION)
fun <T> Observable<T>.throttleLatest(throttleDelay: Long = THROTTLE_CLICK_WINDOW_DURATION): Observable<T> = throttleLatest(throttleDelay, TimeUnit.MILLISECONDS, true)

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Observable<T>.apply(action: (T) -> Unit): Observable<T> {
    return map {
        action(it)

        it
    }
}

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Observable<T>.withDefault(value: T): Observable<T> {
    return this.startWith(Observable.just(value))
}

@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Observable<T>.withDefault(value: Observable<T>): Observable<T> {
    return this.startWith(value.firstElement().toObservable())
}

fun <T : Any> Observable<T>.filter(observableSource: ObservableSource<Boolean>): Observable<T> {
    return this.withLatestFrom(observableSource).filter { it.second }.map { it.first }
}

fun <T : Any> Observable<T>.comparePrevious(): Observable<Pair<T, T>> {
    return Observables.zip(
        this,
        this.skip(1)
    )
}
