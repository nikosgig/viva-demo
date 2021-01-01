package com.nikosgig.viva.features.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class VivaAppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: Any, clickListener: OnItemClickListener)

    interface OnItemClickListener {
        fun onItemClicked(item: Any)
    }
}