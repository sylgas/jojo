package pl.lusy.jojo.journeyjournal.view.common.view

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText

fun View.snackbar(@StringRes textId: Int) =
    Snackbar.make(this, textId, Snackbar.LENGTH_LONG).show()

var View.shown: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

val View.inflater: LayoutInflater
    get() = LayoutInflater.from(context)

fun EditText.setMaxLength(maxLength: Int) {
    filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
}
