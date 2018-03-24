package pl.lusy.jojo.journeyjournal.view.main.adapter

import android.support.v7.widget.RecyclerView
import pl.lusy.jojo.journeyjournal.BR
import pl.lusy.jojo.journeyjournal.databinding.ListHomeItemBinding
import pl.lusy.jojo.journeyjournal.view.main.model.item.HomeItem

class HomeItemViewHolder(private val binding: ListHomeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeItem) = with(binding) {
        binding.setVariable(BR.homeItem, item)
    }
}