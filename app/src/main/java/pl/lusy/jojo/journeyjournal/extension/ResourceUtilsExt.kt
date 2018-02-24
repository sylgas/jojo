package pl.lusy.jojo.journeyjournal.extension

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast

fun View.snackbar(@StringRes textId: Int) =
    Snackbar.make(this, textId, Snackbar.LENGTH_LONG).show()

var View.shown: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable =
    ContextCompat.getDrawable(this, drawableRes)!!

fun Context.toast(@StringRes textId: Int) =
    Toast.makeText(this, textId, Toast.LENGTH_LONG).show()
