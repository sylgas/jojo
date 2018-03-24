package pl.lusy.jojo.journeyjournal.view.main.adapter

import android.support.v7.widget.RecyclerView
import pl.lusy.jojo.journeyjournal.BR
import pl.lusy.jojo.journeyjournal.databinding.ViewHomeItemBinding
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.HomeItem

class HomeItemViewHolder(private val binding: ViewHomeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HomeItem) = with(binding) {
        binding.setVariable(BR.homeItem, item)
    }
}