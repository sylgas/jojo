package pl.lusy.jojo.journeyjournal.view.welcome.view

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.view_pagination.view.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.extension.shown

class PaginationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CoordinatorLayout(context, attrs, defStyleAttr), ViewPager.OnPageChangeListener {
    private val views: List<View>

    init {
        inflate(getContext(), R.layout.view_pagination, this)
        firstStepDot.isSelected = true
        views = listOf(firstStepDot, secondStepDot, thirdStepDot)
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int,
                                positionOffset: Float,
                                positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        views.forEachIndexed { index, view -> view.isSelected = position == index }
        skipButton.shown = position != views.lastIndex
    }
}