package pl.lusy.jojo.journeyjournal.data.prefs

import android.content.SharedPreferences
import com.chibatching.kotpref.KotprefModel
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import kotlin.reflect.KProperty0

object Preferences : KotprefModel() {
    var displayWelcomeScreen by booleanPref(default = true)
}

fun <T> KotprefModel.asFlowable(property: KProperty0<T>): Flowable<T> =
    Flowable.create<T>({ emitter ->
        val observedPropertyKey = property.name
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            if (observedPropertyKey == key) {
                emitter.onNext(property.get())
            }
        }
        emitter.setCancellable {
            preferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
        preferences.registerOnSharedPreferenceChangeListener(listener)
    }, BackpressureStrategy.LATEST)

fun <T> KotprefModel.asSingle(property: KProperty0<T>): Single<T> =
    Single.create<T>({ emitter -> emitter.onSuccess(property.get()) })
