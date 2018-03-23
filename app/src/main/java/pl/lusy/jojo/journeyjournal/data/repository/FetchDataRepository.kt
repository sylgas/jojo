package pl.lusy.jojo.journeyjournal.data.repository

import io.reactivex.Flowable

interface FetchDataRepository<T> {
    fun fetch(): Flowable<List<T>>
}
