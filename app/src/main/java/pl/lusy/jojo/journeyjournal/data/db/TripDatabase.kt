package pl.lusy.jojo.journeyjournal.data.db

import pl.lusy.jojo.journeyjournal.data.db.entity.TripEntity

interface TripDatabase : ReadDatabase<TripEntity>, WriteDatabase<TripEntity>
