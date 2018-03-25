package pl.lusy.jojo.journeyjournal.data.repository

import io.reactivex.Completable

interface SaveDataRepository<in T> {
    fun save(data: T): Completable
}
