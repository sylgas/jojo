package pl.lusy.jojo.journeyjournal.view.splash

import android.os.Bundle
import pl.lusy.jojo.journeyjournal.view.common.CoreActivity
import pl.lusy.jojo.journeyjournal.view.main.MainActivity

class SplashActivity : CoreActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.start(this)
        finish()
    }
}