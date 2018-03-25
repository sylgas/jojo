package pl.lusy.jojo.journeyjournal.data.mapper

import pl.lusy.jojo.journeyjournal.data.db.entity.TripEntity
import pl.lusy.jojo.journeyjournal.data.model.Trip

fun TripEntity.toTrip() = Trip(id, planId, name, startDate, endDate)

fun List<TripEntity>.toTrips() = map { it.toTrip() }

fun Trip.toTripEntity() = TripEntity(id, planId, name, startDate, endDate)
