package com.shubham.marketpulse.features.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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
        navController = (supportFragmentManager.findFragmentById(R.id.f_nav_host) as NavHostFragment).navController
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
        if (i_shimmer?.visibility == View.GONE) {
            i_shimmer?.visibility = View.VISIBLE
            sfl_shimmer?.startShimmer()
        }
    }

    private fun hideShimmer() {
        if (i_shimmer?.visibility == View.VISIBLE) {
            sfl_shimmer?.stopShimmer()
            i_shimmer?.visibility = View.GONE
        }
    }
}