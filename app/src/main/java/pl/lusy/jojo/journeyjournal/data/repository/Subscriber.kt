package pl.lusy.jojo.journeyjournal.data.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun <T> Flowable<T>.subscribeIo(): Flowable<T> = subscribeOn(Schedulers.io())
fun Completable.subscribeIo(): Completable = subscribeOn(Schedulers.io())
