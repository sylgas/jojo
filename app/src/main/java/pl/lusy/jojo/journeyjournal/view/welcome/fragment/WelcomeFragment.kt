package pl.lusy.jojo.journeyjournal.view.welcome.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_welcome.*
import kotlinx.android.synthetic.main.view_pagination.*
import pl.lusy.jojo.journeyjournal.databinding.FragmentWelcomeBinding
import pl.lusy.jojo.journeyjournal.view.welcome.adapter.WelcomePageAdapter
import javax.inject.Inject

class WelcomeFragment : DaggerFragment() {
    companion object {
        fun newInstance(): WelcomeFragment = WelcomeFragment()
    }

    @Inject
    lateinit var welcomePageAdapter: WelcomePageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentWelcomeBinding.inflate(inflater, container!!, false).root
    }

    override fun onResume() {
        super.onResume()
        viewPager.addOnPageChangeListener(pagination)
        viewPager.adapter = welcomePageAdapter
        nextButton.setOnClickListener { selectNextPageOrFinish() }
        skipButton.setOnClickListener { finishActivity() }
    }

    private fun selectNextPageOrFinish() {
        val pagesCount = viewPager.adapter?.count ?: 1
        val maxPage = pagesCount - 1
        if (viewPager.currentItem == maxPage) {
            finishActivity()
        } else {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
    }

    private fun finishActivity() {
        activity?.run { finish() }
    }

    override fun onPause() {
        super.onPause()
        viewPager.removeOnPageChangeListener(pagination)
    }
}
