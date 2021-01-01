package com.nikosgig.viva.features.productList

import android.app.Application
import androidx.lifecycle.*
import com.nikosgig.viva.R
import com.nikosgig.viva.data.database.VivaDatabase
import com.nikosgig.viva.data.model.ProductModel
import com.nikosgig.viva.data.network.VivaApi
import kotlinx.coroutines.launch

class ProductListViewModel(application: Application) : AndroidViewModel(application) {

    private val _products = MutableLiveData<List<ProductModel>>()
    val products: LiveData<List<ProductModel>>
        get() = _products

    private val repository =
        ProductListRepository(VivaDatabase.getDatabase(application).productsDao())

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }

    fun getProductsFromApi() {
        viewModelScope.launch {
            repository.insertProductListToDatabase(VivaApi.retrofitService.getProducts())
            _products.value = repository.getProducts()
        }
    }

}