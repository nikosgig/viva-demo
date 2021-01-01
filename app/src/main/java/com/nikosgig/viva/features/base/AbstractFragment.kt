package com.nikosgig.viva.features.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class AbstractFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract fun bindUI()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }
}