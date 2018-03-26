package pl.lusy.jojo.journeyjournal.view.history.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView.VERTICAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_history.*
import pl.lusy.jojo.journeyjournal.databinding.FragmentHistoryBinding
import pl.lusy.jojo.journeyjournal.extension.toast
import pl.lusy.jojo.journeyjournal.view.history.adapter.TripAdapter
import pl.lusy.jojo.journeyjournal.view.history.model.HistoryModel
import javax.inject.Inject

class HistoryFragment : DaggerFragment() {
    companion object {
        fun newInstance(): DaggerFragment = HistoryFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val historyModel: HistoryModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HistoryModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentHistoryBinding.inflate(inflater, container!!, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewListeners()
    }

    private fun setupRecyclerView() {
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.adapter = createRecyclerAdapter()
    }

    private fun invalidateRecyclerView() {
        setupRecyclerView()
        recyclerView.invalidate()
    }

    private fun setupViewListeners() {
        historyModel.trips.observe(this, Observer { invalidateRecyclerView() })
        historyModel.errorMessage.observe(this, Observer { showError(it) })
    }

    private fun createRecyclerAdapter(): TripAdapter {
        val tripItems = historyModel.trips.value ?: emptyList()
        return TripAdapter(tripItems)
    }

    private fun showError(errorMessage: String?) {
        errorMessage?.let { activity?.toast(it) }
    }
}
