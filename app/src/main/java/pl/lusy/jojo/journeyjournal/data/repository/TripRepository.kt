package pl.lusy.jojo.journeyjournal.data.repository

import pl.lusy.jojo.journeyjournal.data.model.Trip

interface TripRepository :
    GetDataRepository<Trip>,
    SaveDataRepository<Trip>,
    FetchDataRepository<Trip>
