package com.nikosgig.viva.features.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nikosgig.viva.MainActivity
import com.nikosgig.viva.R
import com.nikosgig.viva.features.productList.ProductListViewModel

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
        viewModel.isDataReady.observe(this, { isReady ->
            when (isReady) {
                true -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.nav_default_enter_anim, R.anim.nav_default_exit_anim)
                    finish()
                }
            }
        })
    }
}