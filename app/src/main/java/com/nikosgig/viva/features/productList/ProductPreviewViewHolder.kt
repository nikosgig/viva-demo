package com.nikosgig.viva.features.productList

import android.view.View
import com.bumptech.glide.Glide
import com.nikosgig.viva.data.model.ProductModel
import com.nikosgig.viva.features.base.VivaAppViewHolder
import kotlinx.android.synthetic.main.holder_product_preview.view.*

class ProductPreviewViewHolder(itemView: View): VivaAppViewHolder(itemView) {

    override fun bind(item: Any, clickListener: OnItemClickListener) {
        when(item) {
            is ProductModel -> {
                itemView.product_preview_name.text = item.name
                itemView.product_preview_price.text = item.price
                Glide.with(itemView.context).load(item.thumbnail).into(itemView.product_preview_image)
                itemView.setOnClickListener {
                    clickListener.onItemClicked(item)
                }
            }
        }
    }

}