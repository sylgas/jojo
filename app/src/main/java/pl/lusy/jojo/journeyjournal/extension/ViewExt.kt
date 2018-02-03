package pl.lusy.jojo.journeyjournal.extension

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

fun View.snackbar(@StringRes textId: Int) =
        Snackbar.make(this, textId, Snackbar.LENGTH_LONG).show()
