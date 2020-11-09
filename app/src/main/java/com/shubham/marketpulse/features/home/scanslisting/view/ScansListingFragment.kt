package com.shubham.marketpulse.features.home.scanslisting.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shubham.marketpulse.R
import com.shubham.marketpulse.base.BaseFragment
import com.shubham.marketpulse.features.home.HomeActivityViewModel
import com.shubham.marketpulse.features.home.scanslisting.adapter.ScansListingRecyclerAdapter
import com.shubham.marketpulse.features.home.scanslisting.communicator.ScansListingRecyclerAdapterCallback
import com.shubham.marketpulse.features.home.scanslisting.viewmodel.ScansListingFragmentViewModel
import com.shubham.marketpulse.model.ScansData
import com.shubham.marketpulse.utility.toast
import kotlinx.android.synthetic.main.fragment_scans_listing.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
class ScansListingFragment : BaseFragment(R.layout.fragment_scans_listing),
    ScansListingRecyclerAdapterCallback {

    private var homeActivityViewModel: HomeActivityViewModel? = null
    private lateinit var viewModel: ScansListingFragmentViewModel
    private var adapter: ScansListingRecyclerAdapter? = null

    /* Lifecycle */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSubscriptions()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecycler()
        applySwipeRefresh()
        renderToolbar()
        fetchScansData()
    }

    /* Implementations */

    private fun setupViewModel() {
        homeActivityViewModel = activity?.let {
            ViewModelProvider(
                it, viewModelFactory
            )[HomeActivityViewModel::class.java]
        }
        viewModel = ViewModelProvider(
            this, viewModelFactory
        )[ScansListingFragmentViewModel::class.java]
    }

    private fun setupSubscriptions() {
        viewModel.observeError().observe(viewLifecycleOwner, { message ->
            message?.let { toast(it) }
        })
    }

    private fun configureRecycler() {
        if (adapter == null) {
            adapter = ScansListingRecyclerAdapter(this)
        }
        rv_list?.let {
            with(it) {
                layoutManager = LinearLayoutManager(this.context)
                adapter = this@ScansListingFragment.adapter
            }
        }
    }

    private fun applySwipeRefresh() {
        srl_refresh?.setOnRefreshListener {
            showSwipeRefresh()
            fetchScansData()
        }
    }

    private fun renderToolbar() {
        iv_back?.visibility = View.GONE
        tv_title?.visibility = View.VISIBLE
        tv_title?.text = getString(R.string.scans_listing_title)
    }

    private fun fetchScansData() {
        viewModel.fetchScansData().observe(viewLifecycleOwner, { data ->
            hideSwipeRefresh()
            data?.let {
                populateRecycler(it)
            }
        })
    }

    private fun populateRecycler(data: List<ScansData>) {
        adapter?.setData(data)
    }

    /* Callbacks */

    override fun onScanClicked(id: Int) {
        homeActivityViewModel?.yieldNavigation(ScansListingFragmentDirections
            .actionScansListingFragmentToScanCriteriaFragment(scanId = id)
        )
    }

    /* Utilities */

    private fun showSwipeRefresh() {
        srl_refresh?.let {
            if (!it.isRefreshing) {
                it.isRefreshing = true
            }
        }
    }

    private fun hideSwipeRefresh() {
        srl_refresh?.let {
            if (it.isRefreshing) {
                it.isRefreshing = false
            }
        }
    }
}