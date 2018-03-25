package pl.lusy.jojo.journeyjournal.data.db

import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.dao.TripDao
import pl.lusy.jojo.journeyjournal.data.db.entity.TripEntity
import javax.inject.Inject

class TripRoomDatabase @Inject constructor(
    private val tripDao: TripDao
) : TripDatabase {
    override fun getAll(): Flowable<List<TripEntity>> =
        tripDao.getAll()

    override fun get(id: Long): Flowable<TripEntity> =
        tripDao.get(id)

}