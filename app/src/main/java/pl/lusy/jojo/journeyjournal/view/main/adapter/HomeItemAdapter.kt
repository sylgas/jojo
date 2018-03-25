package pl.lusy.jojo.journeyjournal.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import pl.lusy.jojo.journeyjournal.databinding.ViewHomeItemBinding
import pl.lusy.jojo.journeyjournal.view.history.adapter.ListAdapter
import pl.lusy.jojo.journeyjournal.view.history.adapter.ListItemHolder
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.HomeItem

class HomeItemAdapter(items: List<HomeItem>) : ListAdapter<HomeItem>(items) {

    override fun getHolder(inflater: LayoutInflater, parent: ViewGroup): ListItemHolder<HomeItem> {
        val binding = ViewHomeItemBinding.inflate(inflater, parent, false)
        return ListItemHolder(binding)
    }

}