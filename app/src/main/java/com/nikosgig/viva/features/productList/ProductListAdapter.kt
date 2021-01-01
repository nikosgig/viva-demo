package com.nikosgig.viva.features.productList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nikosgig.viva.R
import com.nikosgig.viva.data.model.ProductModel
import com.nikosgig.viva.features.base.EmptyPreviewViewHolder
import com.nikosgig.viva.features.base.VivaAppViewHolder

class ProductListAdapter(private val itemClickListener: VivaAppViewHolder.OnItemClickListener) :
    ListAdapter<ProductModel, VivaAppViewHolder>(ProductListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VivaAppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.holder_product_preview -> ProductPreviewViewHolder(view)
            else -> EmptyPreviewViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: VivaAppViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickListener)
    }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is ProductModel -> R.layout.holder_product_preview
            else -> R.layout.holder_empty_preview
        }
}

