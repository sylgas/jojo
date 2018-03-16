package pl.lusy.jojo.journeyjournal.view.common.view

import android.content.Context
import android.support.annotation.IntegerRes
import android.support.design.widget.CoordinatorLayout
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import kotlinx.android.synthetic.main.view_limited_text_input.view.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.setMaxLength
import pl.lusy.jojo.journeyjournal.extension.shown

class LimitedTextInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr) {

    private val inputTextWatcher = object : TextWatcher {
        override fun afterTextChanged(text: Editable?) {
            textProgress.text = text?.length.toString()
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

    init {
        inflate(getContext(), R.layout.view_limited_text_input, this)
    }

    fun setTextLimit(@IntegerRes limitRes: Int) {
        val limitValue = context.resources.getInteger(limitRes)
        limit.text = limitValue.toString()
        limitDescription.text = context.getString(R.string.trip_details_limit_desc, limitValue)
        inputText.setMaxLength(limitValue)
        inputText.addTextChangedListener(inputTextWatcher)
    }

    fun addTextChangedListener(textWatcher: TextWatcher) {
        inputText.addTextChangedListener(textWatcher)
    }

    fun setTextLimitDetailsVisible(isVisible: Boolean) {
        limitDetails.shown = isVisible
    }

    fun setText(textString: String?) {
        inputText.setText(textString)
    }

}
