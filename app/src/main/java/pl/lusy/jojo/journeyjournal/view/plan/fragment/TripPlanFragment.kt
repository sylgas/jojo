package pl.lusy.jojo.journeyjournal.view.plan.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import pl.lusy.jojo.journeyjournal.data.model.PlanStep
import pl.lusy.jojo.journeyjournal.databinding.FragmentTripPlanBinding
import pl.lusy.jojo.journeyjournal.view.plan.model.TripPlanModel
import javax.inject.Inject

class TripPlanFragment : DaggerFragment() {
    companion object {
        fun newInstance(): TripPlanFragment = TripPlanFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val planModel: TripPlanModel by lazy {
        ViewModelProviders.of(activity!!, viewModelFactory).get(TripPlanModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentTripPlanBinding.inflate(inflater, container!!, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupViewListeners()
    }

    private fun setupView() {
    }

    private fun setupViewListeners() {
        planModel.planSteps.observe(this, Observer {
            updateTripSteps(it!!)
        })
    }

    private fun updateTripSteps(steps: List<PlanStep>) {
        if (view != null) {
            Snackbar.make(view!!, steps.size.toString(), Snackbar.LENGTH_LONG)
        }

    }
}