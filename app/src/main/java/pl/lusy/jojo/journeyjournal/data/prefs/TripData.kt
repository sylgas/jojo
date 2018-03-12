package pl.lusy.jojo.journeyjournal.data.prefs

import android.content.SharedPreferences
import android.support.annotation.CheckResult
import com.chibatching.kotpref.KotprefModel
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import kotlin.reflect.KProperty0

object TripData : KotprefModel() {
    var name by stringPref()
    var startDate by longPref()
    var endDate by longPref()
}

@CheckResult
fun <T> KotprefModel.asFlowable(property: KProperty0<T>): Flowable<T> =
    Flowable.create<T>({ emitter ->
        val observedPropertyKey = property.name
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (observedPropertyKey === key) {
                emitter.onNext(property.get())
            }
        }
        emitter.setCancellable {
            preferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }, BackpressureStrategy.LATEST)
