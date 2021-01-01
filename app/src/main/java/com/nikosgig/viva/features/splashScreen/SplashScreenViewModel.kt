package com.nikosgig.viva.features.splashScreen

import android.app.Application
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nikosgig.viva.R
import com.nikosgig.viva.data.database.VivaDatabase
import com.nikosgig.viva.data.network.VivaApi
import com.nikosgig.viva.features.productList.ProductListRepository
import kotlinx.coroutines.launch


class SplashScreenViewModel(application: Application): AndroidViewModel(application) {

    private val _application = application
    private val _isDataReady = MutableLiveData<Boolean>()
    val isDataReady: LiveData<Boolean>
        get() = _isDataReady

    private val prefs = PreferenceManager.getDefaultSharedPreferences(application)

    private val repository =
        ProductListRepository(VivaDatabase.getDatabase(application).productsDao())

    init {
        when(prefs.getBoolean(application.getString(R.string.key_call_api), false)) {
            false -> getProductsFromApi()
            true -> _isDataReady.value = true
        }
    }

    private fun getProductsFromApi() {
        viewModelScope.launch {
            repository.insertProductListToDatabase(VivaApi.retrofitService.getProducts())
            prefs.edit().putBoolean(_application.getString(R.string.key_call_api), true).apply()
            _isDataReady.value = true
        }
    }
}