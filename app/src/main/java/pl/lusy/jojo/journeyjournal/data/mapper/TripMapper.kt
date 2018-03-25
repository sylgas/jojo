package pl.lusy.jojo.journeyjournal.data.mapper

import pl.lusy.jojo.journeyjournal.data.db.entity.TripEntity
import pl.lusy.jojo.journeyjournal.data.model.Trip

fun TripEntity.toTrip() = Trip(name)