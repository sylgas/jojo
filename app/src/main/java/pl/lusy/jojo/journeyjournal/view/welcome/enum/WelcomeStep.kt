package pl.lusy.jojo.journeyjournal.view.welcome.enum

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import pl.lusy.jojo.journeyjournal.R

enum class WelcomeStep(@StringRes val titleResId: Int,
                       @StringRes val descriptionResId: Int,
                       @DrawableRes val imageResId: Int) {
    PLAN_TRIP(
        R.string.plan_trip_title,
        R.string.plan_trip_description,
        R.drawable.people
    ),
    TAKE_PHOTOS(
        R.string.take_photos_title,
        R.string.take_photos_description,
        R.drawable.people
    ),
    ENJOY(
        R.string.enjoy_title,
        R.string.enjoy_description,
        R.drawable.people
    )
}