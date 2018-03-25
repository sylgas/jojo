package pl.lusy.jojo.journeyjournal.data.db

import pl.lusy.jojo.journeyjournal.data.db.entity.DatabaseEntity

interface WriteDatabase<in T : DatabaseEntity> {

    fun save(entity: T)

}
