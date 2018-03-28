package pl.lusy.jojo.journeyjournal.view.common.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.annotation.IntegerRes
import android.support.design.widget.CoordinatorLayout
import android.text.TextWatcher
import android.util.AttributeSet
import pl.lusy.jojo.journeyjournal.BR
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.databinding.ViewLimitedTextInputBinding

class LimitedTextInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr) {

    private val binding by lazy {
        DataBindingUtil.inflate<ViewLimitedTextInputBinding>(
            inflater,
            R.layout.view_limited_text_input,
            this,
            true
        )
    }

    fun setTextLimit(@IntegerRes limitRes: Int) {
        val limitValue = context.resources.getInteger(limitRes)
        binding.setVariable(BR.limit, limitValue.toString())
        val limitDescription = context.getString(R.string.trip_details_limit_desc, limitValue)
        binding.setVariable(BR.description, limitDescription)
        binding.inputText.setMaxLength(limitValue)
    }

    fun addTextChangedListener(textWatcher: TextWatcher) {
        binding.inputText.addTextChangedListener(textWatcher)
    }

    fun setTextLimitDetailsVisible(isVisible: Boolean) {
        binding.limitDetails.shown = isVisible
    }

    fun setText(textString: String?) {
        binding.setVariable(BR.text, textString ?: "")
    }

}
