package pl.lusy.jojo.journeyjournal.data.db

import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.entity.EntityRelation

interface RelationDatabase<T : EntityRelation> {
    fun getAllWithRelation(): Flowable<List<T>>

    fun getWithRelation(id: Long): Flowable<T>
}
