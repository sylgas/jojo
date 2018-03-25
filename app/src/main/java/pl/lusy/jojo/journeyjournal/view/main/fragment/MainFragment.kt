package pl.lusy.jojo.journeyjournal.view.main.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import pl.lusy.jojo.journeyjournal.databinding.FragmentMainBinding
import pl.lusy.jojo.journeyjournal.view.main.adapter.HomeItemAdapter
import pl.lusy.jojo.journeyjournal.view.main.model.MainViewModel

class MainFragment : DaggerFragment() {
    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    private val mainModel: MainViewModel by lazy {
        ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater, container!!, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = createRecyclerAdapter()
        recyclerView.setHasFixedSize(true)
    }

    private fun createRecyclerAdapter(): HomeItemAdapter {
        val homeItems = mainModel.homeItems.value ?: emptyList()
        return HomeItemAdapter(homeItems)
    }
}