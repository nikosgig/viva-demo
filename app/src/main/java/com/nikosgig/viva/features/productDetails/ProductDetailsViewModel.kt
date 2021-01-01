package com.nikosgig.viva.features.productDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nikosgig.viva.data.database.VivaDatabase
import com.nikosgig.viva.data.model.ProductModel
import com.nikosgig.viva.features.productList.ProductListRepository
import kotlinx.coroutines.launch

class ProductDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val _productDetails = MutableLiveData<ProductModel>()
    val productDetails: LiveData<ProductModel>
        get() = _productDetails

    private val repository =
        ProductListRepository(VivaDatabase.getDatabase(application).productsDao())

    fun getProductDetails(id: Int) {
        viewModelScope.launch {
            _productDetails.value = repository.getProductById(id)
        }
    }
}