package pl.lusy.jojo.journeyjournal.data.prefs

import com.chibatching.kotpref.KotprefModel

object TripData : KotprefModel() {
    var name by stringPref()
    var startDate by longPref()
    var endDate by longPref()
}
