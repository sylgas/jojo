package pl.lusy.jojo.journeyjournal.view.welcome.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_welcome_page.*
import pl.lusy.jojo.journeyjournal.R
import pl.lusy.jojo.journeyjournal.view.welcome.enum.WelcomeStep


class WelcomePageFragment : Fragment() {
    companion object {
        private const val WELCOME_STEP_ARG = "WELCOME_STEP"

        fun newInstance(welcomeStep: WelcomeStep): WelcomePageFragment {
            val bundle = Bundle()
            bundle.putSerializable(WELCOME_STEP_ARG, welcomeStep)
            val fragment = WelcomePageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welcome_page, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val step = getStepArgument()

        view.run {
            image.setImageResource(step.imageResId)
            title.text = context.getString(step.titleResId)
            description.text = context.getString(step.descriptionResId)
        }
    }

    private fun getStepArgument() = arguments?.get(WELCOME_STEP_ARG)?.let { it as WelcomeStep }
        ?: WelcomeStep.PLAN_TRIP
}
