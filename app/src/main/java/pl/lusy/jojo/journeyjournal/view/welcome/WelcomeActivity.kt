package pl.lusy.jojo.journeyjournal.view.welcome

import android.content.Context
import android.os.Bundle
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.common.CoreActivity
import pl.lusy.jojo.journeyjournal.view.common.replaceContentWithFragment
import pl.lusy.jojo.journeyjournal.view.common.startCustomActivity
import pl.lusy.jojo.journeyjournal.view.welcome.fragment.WelcomeFragment

class WelcomeActivity : CoreActivity() {
    companion object {
        fun start(context: Context) = context.startCustomActivity<WelcomeActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setupFragment()
    }

    private fun setupFragment() {
        replaceContentWithFragment(WelcomeFragment.newInstance())
    }
}
