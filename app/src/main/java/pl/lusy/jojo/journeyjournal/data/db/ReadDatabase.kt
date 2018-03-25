package pl.lusy.jojo.journeyjournal.data.db

import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.entity.DatabaseEntity

interface ReadDatabase<T : DatabaseEntity> {
    fun getAll(): Flowable<List<T>>

    fun get(id: Long): Flowable<T>
}
