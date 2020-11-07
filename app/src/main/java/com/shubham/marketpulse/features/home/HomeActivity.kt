package com.shubham.marketpulse.features.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.shubham.marketpulse.R
import com.shubham.marketpulse.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_shimmer.*

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
class HomeActivity: BaseActivity(R.layout.activity_home) {

    private lateinit var navController: NavController
    private lateinit var viewModel: HomeActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
        setupViewModel()
        setupSubscriptions()
    }

    private fun setupNavigation() {
        navController = findNavController(f_nav_host.id)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this, viewModelFactory
        )[HomeActivityViewModel::class.java]
    }

    private fun setupSubscriptions() {
        viewModel.observeNavigation().observe(this, { directions ->
            directions?.let { navController.navigate(it) }
        })
        viewModel.observeShimmerStatus().observe(this, { status ->
            if (status) showShimmer() else hideShimmer()
        })
    }

    private fun showShimmer() {
        if (sfl_shimmer?.visibility == View.GONE) {
            sfl_shimmer?.visibility = View.VISIBLE
            sfl_shimmer?.startShimmer()
        }
    }

    private fun hideShimmer() {
        if (sfl_shimmer?.visibility == View.VISIBLE) {
            sfl_shimmer?.stopShimmer()
            sfl_shimmer?.visibility = View.GONE
        }
    }
}