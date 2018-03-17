package pl.lusy.jojo.journeyjournal.view.history.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import pl.lusy.jojo.journeyjournal.databinding.FragmentHistoryBinding

class HistoryFragment : DaggerFragment() {
    companion object {
        fun newInstance(): DaggerFragment = HistoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentHistoryBinding.inflate(inflater, container!!, false).root
    }
}
