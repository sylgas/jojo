package pl.lusy.jojo.journeyjournal.data.repository

import io.reactivex.Flowable

interface GetDataRepository<T> {
    fun get(id: Long): Flowable<T>
}
