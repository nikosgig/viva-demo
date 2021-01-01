package com.nikosgig.viva.features.productList

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nikosgig.viva.R
import com.nikosgig.viva.data.model.ProductModel
import com.nikosgig.viva.features.base.AbstractFragment
import com.nikosgig.viva.features.base.VivaAppViewHolder
import kotlinx.android.synthetic.main.product_list_fragment.*

class ProductListFragment : AbstractFragment(R.layout.product_list_fragment), VivaAppViewHolder.OnItemClickListener {

    private val productListAdapter = ProductListAdapter(this)
    private lateinit var viewModel: ProductListViewModel

    override fun bindUI() {
        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)
        recycler_view_product_list.adapter = productListAdapter
        viewModel.products.observe(viewLifecycleOwner, Observer { productList ->
            if (productList == null) return@Observer
            productListAdapter.submitList(productList)
        })

        fab_refresh.setOnClickListener {
            viewModel.getProductsFromApi()
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.products.removeObservers(this)
    }

    override fun onItemClicked(item: Any) {
        when(item) {
            is ProductModel -> {
                val actionProductDetail = ProductListFragmentDirections.actionProductListToProductDetails(item.id)
                view?.let { Navigation.findNavController(it).navigate(actionProductDetail) }
            }
        }
    }
}