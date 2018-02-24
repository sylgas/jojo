package pl.lusy.jojo.journeyjournal.view.welcome.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pl.lusy.jojo.journeyjournal.view.welcome.fragment.WelcomePageFragment
import java.lang.IllegalArgumentException

class WelcomePageAdapter(
    fragmentManager: FragmentManager,
    private val fragments: List<WelcomePageFragment>
) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount() = fragments.size

    override fun getItem(position: Int) = if (position < fragments.size)
        fragments[position] else
        throw IllegalArgumentException("Pagination adapter supports only ${fragments.size} pages")
}
