package pl.lusy.jojo.journeyjournal.view.history.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import pl.lusy.jojo.journeyjournal.BR

class ListItemHolder<in I>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: I) = with(binding) {
        binding.setVariable(BR.item, item)
    }
}
