package com.alaaeddinalbarghoth.rxandroidapp.rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class RxBasics {

    fun testObservables() {
        val dataStream = Observable.just(10, 20, 30, 40)
        val dataObserver = object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Int) {
                TODO("Not yet implemented")
            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }
        }
    }
}
