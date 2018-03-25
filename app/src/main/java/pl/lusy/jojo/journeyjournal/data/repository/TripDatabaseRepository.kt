package pl.lusy.jojo.journeyjournal.data.repository

import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.TripDatabase
import pl.lusy.jojo.journeyjournal.data.mapper.toTrip
import pl.lusy.jojo.journeyjournal.data.model.Trip
import javax.inject.Inject

class TripDatabaseRepository @Inject constructor(
    private val database: TripDatabase
) : TripRepository {

    override fun get(id: Long): Flowable<Trip> = database.get(id).map { it.toTrip() }

}