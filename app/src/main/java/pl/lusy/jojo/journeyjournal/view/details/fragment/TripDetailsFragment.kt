package pl.lusy.jojo.journeyjournal.view.details.fragment

import android.arch.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import pl.lusy.jojo.journeyjournal.view.details.model.TripDetailsModel

class TripDetailsFragment : DaggerFragment() {
    companion object {
        fun newInstance(): TripDetailsFragment = TripDetailsFragment()
    }

    private val tripModel: TripDetailsModel by lazy {
        ViewModelProviders.of(this).get(TripDetailsModel::class.java)
    }
}