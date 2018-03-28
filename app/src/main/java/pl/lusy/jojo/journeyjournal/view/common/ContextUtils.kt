package pl.lusy.jojo.journeyjournal.view.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.widget.Toast

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable =
    ContextCompat.getDrawable(this, drawableRes)!!

fun Context.toast(@StringRes textId: Int) =
    Toast.makeText(this, textId, Toast.LENGTH_LONG).show()

fun Context.toast(text: String) =
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
