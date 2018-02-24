package pl.lusy.jojo.journeyjournal.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.DaggerFragment
import pl.lusy.jojo.journeyjournal.databinding.FragmentMainBinding

class MainFragment : DaggerFragment() {
    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater, container!!, false).root
    }
}