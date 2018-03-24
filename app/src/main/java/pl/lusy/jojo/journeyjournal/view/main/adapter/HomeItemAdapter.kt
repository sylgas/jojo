package pl.lusy.jojo.journeyjournal.view.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.lusy.jojo.journeyjournal.databinding.ViewHomeItemBinding
import pl.lusy.jojo.journeyjournal.view.main.adapter.item.HomeItem

class HomeItemAdapter(private val items: List<HomeItem>) :
    RecyclerView.Adapter<HomeItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHomeItemBinding.inflate(inflater, parent, false)
        return HomeItemViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        val bindItem = items[position]
        holder.bind(bindItem)
    }

}