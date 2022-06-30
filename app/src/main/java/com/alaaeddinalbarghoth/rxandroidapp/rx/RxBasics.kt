package com.alaaeddinalbarghoth.rxandroidapp.rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import logcat.LogPriority.ERROR
import logcat.LogPriority.INFO
import logcat.logcat

class RxBasics {

    fun testObservables() {
        val dataStream = Observable.just(10, 20, 30, 40)
        val dataObserver = object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                logcat(INFO) { "testObservables onSubscribe" }
            }

            override fun onNext(t: Int) {
                logcat(INFO) { "testObservables onNext $t" }
            }

            override fun onError(e: Throwable) {
                logcat(ERROR) { "testObservables onError" }
            }

            override fun onComplete() {
                logcat(INFO) { "testObservables onComplete" }
            }
        }

        dataStream.subscribe(dataObserver)
    }
}
