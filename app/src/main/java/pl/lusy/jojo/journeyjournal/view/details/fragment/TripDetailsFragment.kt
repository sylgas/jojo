package pl.lusy.jojo.journeyjournal.view.details.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import pl.lusy.jojo.journeyjournal.databinding.FragmentTripDetailsBinding

class TripDetailsFragment : DaggerFragment() {
    companion object {
        fun newInstance(): TripDetailsFragment = TripDetailsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentTripDetailsBinding.inflate(inflater, container!!, false).root
    }

}