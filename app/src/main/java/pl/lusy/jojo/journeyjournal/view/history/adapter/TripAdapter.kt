package pl.lusy.jojo.journeyjournal.view.history.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.lusy.jojo.journeyjournal.data.model.Trip
import pl.lusy.jojo.journeyjournal.databinding.ViewTripItemBinding
import pl.lusy.jojo.journeyjournal.view.details.TripDetailsActivity

class TripAdapter(items: List<Trip>) : ListAdapter<Trip>(items) {

    override fun getHolder(inflater: LayoutInflater, parent: ViewGroup): ListItemHolder<Trip> {
        val binding = ViewTripItemBinding.inflate(inflater, parent, false)
        val holder = ListItemHolder<Trip>(binding)
        binding.itemHolder.setOnClickListener { handleItemClick(holder, parent.context) }
        return holder
    }

    private fun handleItemClick(holder: ListItemHolder<Trip>, context: Context) {
        val item = holder.bindedItem
        TripDetailsActivity.start(context, item?.id)
    }

}