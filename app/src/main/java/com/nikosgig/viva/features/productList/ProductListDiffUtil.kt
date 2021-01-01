package com.nikosgig.viva.features.productList

import androidx.recyclerview.widget.DiffUtil
import com.nikosgig.viva.data.model.ProductModel

class ProductListDiffUtil : DiffUtil.ItemCallback<ProductModel>() {

    override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem.id == newItem.id
    }
}