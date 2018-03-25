package pl.lusy.jojo.journeyjournal.view.history.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class ListAdapter<I>(
    private val items: List<I>
): RecyclerView.Adapter<ListItemHolder<I>>() {

    abstract fun getHolder(inflater: LayoutInflater, parent: ViewGroup): ListItemHolder<I>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder<I> {
        val inflater = LayoutInflater.from(parent.context)
        return getHolder(inflater, parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ListItemHolder<I>, position: Int) {
        val bindItem = items[position]
        holder.bind(bindItem)
    }

}