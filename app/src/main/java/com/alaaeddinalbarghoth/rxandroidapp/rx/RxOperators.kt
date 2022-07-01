package com.alaaeddinalbarghoth.rxandroidapp.rx

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleSource
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import logcat.LogPriority.ERROR
import logcat.LogPriority.INFO
import logcat.logcat
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@Suppress("UNUSED_EXPRESSION", "SameParameterValue")
class RxOperators {

    /* region Creation Operators */
    private fun createFromCallable(): Observable<String> {
        //  Produce one job only
        return Observable.fromCallable {
            "One job"
        }
    }

    private fun create(boolean: Boolean): Observable<String> {
        //  Produce one job only
        return Observable.create {
            if (boolean)
                "Pla pla pla, One job"

            if (boolean)
                "Say hi, two job"
        }
    }

    private fun createFromArray(): Observable<Array<Int>> {
        return Observable.fromArray(arrayOf(10, 20, 30))
    }

    private fun createFromIterable(): Observable<Int> {
        return Observable.fromIterable(mutableListOf(10, 20, 30))
    }

    private fun createRange(): Observable<Int> {
        return Observable.range(10, 5)
    }

    private fun createInterval(): Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS).takeWhile { value -> value < 20 }
    }

    private fun createTimer(): Observable<Long> {
        return Observable.timer(5, TimeUnit.SECONDS)
    }
    /* endregion */

    /* region Filtering Operators */
    private fun createFilter(): Observable<Int> {
        return Observable.just(2, 30, 40, 5).filter { v -> v > 10 }
    }

    private fun takeLast(): Observable<Int> {
        return Observable.just(2, 30, 40, 5).takeLast(2)
    }

    private fun take(): Observable<Int> {
        return Observable.just(2, 30, 40, 5).take(2)
    }

    private fun timeout(name: String): Observable<String> {
        return Observable.fromCallable {
            if (name == "Alaa")
                Thread.sleep(150)
            name
        }.timeout(100, TimeUnit.MILLISECONDS)
    }

    private fun distinct(): Observable<Int> {
        return Observable.just(1, 2, 2, 4, 5, 5).distinct()
    }
    /* endregion */

    /* region Combining Operators */
    private fun createStartWith(): Observable<String> {
        return Observable.just("Alaa", "Mhd", "Ali").startWith(SingleSource { "Asmaa" })
    }

    private fun createMerge(): Observable<Int> {
        // No Order for streams items
        val stream1 = Observable.just(1, 2, 3)
        val stream2 = Observable.just(4, 5, 6)
        return stream1.mergeWith(stream2)
    }

    private fun createConcat(): Observable<Int> {
        // There is an order for streams items
        val stream1 = Observable.just(1, 2, 3)
        val stream2 = Observable.just(4, 5, 6)
        return stream1.concatWith(stream2)
    }

    private fun createZip(): Observable<Int> {
        // There is a manipulation on data when combining the data, "Using BiFunction"
        val stream1 = Observable.just(1, 2)
        val stream2 = Observable.just(3, 4)
        return stream1.zipWith(stream2, BiFunction { first, last ->
            first + last
        })
    }

    private fun createMap(): Observable<Int> {
        // The output is the same type of an item
        return Observable.just(1, 2, 3, 4, 5)
            .map { it * 10 }
    }

    private fun createFlatMap(): Observable<String> {
        // The output is an observable of another type
        return Observable.just("x1", "x2", "x3")
            .flatMap {
                getName(id = it)
            }
    }

    private fun getName(id: String): Observable<String> {
        val names = arrayOf("Alaa", "Kerim", "Safwan")
        val rand = Random.nextInt(3)

        return Observable.just("ID: $id Name:${names[rand]} ")
    }
    /* endregion */

    /* region Subject */
    private fun createPublishSubject() {
        // This will emit the data instantly
        val professor = PublishSubject.create<String>()
        professor.subscribe(getInClassStudents())
        professor.onNext("1")
        professor.onNext("2")
        professor.onNext("3")
        professor.subscribe(getLateStudents())
        professor.onNext("4")
        professor.onNext("5")
        professor.onNext("6")
        professor.onComplete()
    }

    private fun createReplaySubject() {
        // This will emit the all the previous data and the new data
        val professor = ReplaySubject.create<String>()
        professor.subscribe(getInClassStudents())
        professor.onNext("1")
        professor.onNext("2")
        professor.onNext("3")
        professor.subscribe(getLateStudents())
        professor.onNext("4")
        professor.onNext("5")
        professor.onNext("6")
        professor.onComplete()
    }

    private fun createBehaviorSubject() {
        // This will emit the previous 1 item data and the new data
        val professor = BehaviorSubject.create<String>()
        professor.subscribe(getInClassStudents())
        professor.onNext("1")
        professor.onNext("2")
        professor.onNext("3")
        professor.subscribe(getLateStudents())
        professor.onNext("4")
        professor.onNext("5")
        professor.onNext("6")
        professor.onComplete()
    }

    private fun createAsyncSubject() {
        // This will emit the latest data only after waiting the stream ending
        val professor = AsyncSubject.create<String>()
        professor.subscribe(getInClassStudents())
        professor.onNext("1")
        professor.onNext("2")
        professor.onNext("3")
        professor.subscribe(getLateStudents())
        professor.onNext("4")
        professor.onNext("5")
        professor.onNext("6")
        professor.onComplete()
    }
    /* endregion */

    /* region  */
    /* endregion */

    fun subscribe() {

        /* region Creation Operators */
//        createFromArray().subscribe {
//            logcat(INFO) { "Array $it" }
//        }
//        createFromIterable().subscribe {
//            logcat(INFO) { "Iterable $it" }
//        }
//        createRange().subscribe {
//            logcat(INFO) { "Range $it" }
//        }
//        createInterval().subscribe {
//            logcat(INFO) { "Interval $it" }
//        }
//        createTimer().subscribe {
//            logcat(INFO) { "Timer $it" }
//        }
        /* endregion */

        /* region Filtering Operators */
//        createFilter().subscribe {
//            logcat(INFO) { "Timer $it" }
//        }
//        take().subscribe {
//            logcat(INFO) { "Timer $it" }
//        }
//        timeout("Alaa").subscribe({
//            logcat(INFO) { "Timeout $it" }
//        }, { error ->
//            logcat(ERROR) { "Timeout Error $error" }
//        })
//        distinct().subscribe {
//            logcat(INFO) { "distinct $it" }
//        }
        /* endregion */

        /* region Combining Operators */
//        createStartWith().subscribe({
//            logcat(INFO) { "StartWith $it" }
//        }, { error ->
//            logcat(ERROR) { "StartWith Error $error" }
//        })
//
//        createMerge().subscribe({
//            logcat(INFO) { "Merge is $it" }
//        }, { error ->
//            logcat(ERROR) { "Merge Error is $error" }
//        })
//
//        createConcat().subscribe({
//            logcat(INFO) { "Concat is $it" }
//        }, { error ->
//            logcat(ERROR) { "Concat Error is $error" }
//        })
//
//        createZip().subscribe({
//            logcat(INFO) { "Zip is $it" }
//        }, { error ->
//            logcat(ERROR) { "Zip Error is $error" }
//        })
//
//        createMap().subscribe({
//            logcat(INFO) { "Map is $it" }
//        }, { error ->
//            logcat(ERROR) { "Map Error is $error" }
//        })
//
//        createFlatMap().subscribe({
//            logcat(INFO) { "FlatMap is $it" }
//        }, { error ->
//            logcat(ERROR) { "FlatMap Error is $error" }
//        })
        /* endregion */

        /* region Subject */
//        createPublishSubject()
//        createReplaySubject()
//        createBehaviorSubject()
        createAsyncSubject()
        /* endregion */
    }

    /* region Subject */
    private fun getInClassStudents(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                logcat(INFO) { "getInClassStudents onSubscribe" }
            }

            override fun onNext(t: String) {
                logcat(INFO) { "getInClassStudents $t" }
            }

            override fun onError(e: Throwable) {
                logcat(ERROR) { "getInClassStudents $e" }
            }

            override fun onComplete() {
                logcat(INFO) { "getInClassStudents onComplete" }
            }
        }
    }

    private fun getLateStudents(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                logcat(INFO) { "getLateStudents onSubscribe" }
            }

            override fun onNext(t: String) {
                logcat(INFO) { "getLateStudents $t" }
            }

            override fun onError(e: Throwable) {
                logcat(ERROR) { "getLateStudents $e" }
            }

            override fun onComplete() {
                logcat(INFO) { "getLateStudents onComplete" }
            }
        }
    }
    /* endregion */
}
