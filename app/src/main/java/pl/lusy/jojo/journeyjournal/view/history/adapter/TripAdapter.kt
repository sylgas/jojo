package pl.lusy.jojo.journeyjournal.view.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import pl.lusy.jojo.journeyjournal.data.model.Trip
import pl.lusy.jojo.journeyjournal.databinding.ViewTripItemBinding

class TripAdapter(items: List<Trip>) : ListAdapter<Trip>(items) {

    override fun getHolder(inflater: LayoutInflater, parent: ViewGroup): ListItemHolder<Trip> {
        val binding = ViewTripItemBinding.inflate(inflater, parent, false)
        return ListItemHolder(binding)
    }

}