package com.nikosgig.viva.features.productDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.nikosgig.viva.R
import com.nikosgig.viva.features.base.AbstractFragment
import com.nikosgig.viva.features.productList.ProductListViewModel
import kotlinx.android.synthetic.main.product_details_fragment.*

class ProductDetailsFragment : AbstractFragment(R.layout.product_details_fragment) {

    private lateinit var viewModel: ProductDetailsViewModel

    override fun bindUI() {
        viewModel = ViewModelProvider(this).get(ProductDetailsViewModel::class.java)
        val safeArgs = arguments?.let {
            ProductDetailsFragmentArgs.fromBundle(it)
        }
        safeArgs?.productId?.let {
            viewModel.getProductDetails(it)
        }
        viewModel.productDetails.observe(viewLifecycleOwner, Observer { product ->
            if (product == null) return@Observer

            product_details_name.text = product.name
            product_details_price.text = product.price
            Glide.with(this@ProductDetailsFragment)
                .load(product.image)
                .dontAnimate()
                .into(product_details_image)
        })
    }

}