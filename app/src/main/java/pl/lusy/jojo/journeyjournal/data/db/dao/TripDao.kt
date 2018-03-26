package pl.lusy.jojo.journeyjournal.data.db.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.entity.TripEntity

@Dao
interface TripDao {

    @Query("SELECT * FROM trip ORDER BY startDate")
    fun getAll(): Flowable<List<TripEntity>>

    @Query("SELECT * FROM trip WHERE id = :id")
    fun get(id: Long): Flowable<TripEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(trip: TripEntity)

}