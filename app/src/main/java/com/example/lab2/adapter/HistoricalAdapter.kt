package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.databinding.ListItemBinding
import com.example.lab2.model.Historical

class HistoricalAdapter : ListAdapter<Historical,HistoricalAdapter.HistoricalFigureViewHolder> (HistoricalAdapterCallBack()){

    class HistoricalAdapterCallBack:DiffUtil.ItemCallback<Historical>(){
        override fun areItemsTheSame(oldItem: Historical, newItem: Historical): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Historical, newItem: Historical): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricalFigureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return HistoricalFigureViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoricalFigureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HistoricalFigureViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private var binding = ListItemBinding.bind(view)

        fun bind(historical: Historical) = with(binding){
            tvName.text = historical.name
            tvTitle.text = historical.title
            if (historical.info.born == null){
                tvBorn.text = "No information"
                tvDied.text = ""
                tvChildren.text = ""
            }
            else{
                if (historical.info.died == null){
                    tvDied.text = "Alive"
                } else{
                    tvDied.text = "Died in: ${historical.info.died}"
                }
                tvBorn.text = "Born in: ${historical.info.born}"
                tvChildren.text = "Has ${historical.info.children.toString()} children"
            }
        }

    }

}