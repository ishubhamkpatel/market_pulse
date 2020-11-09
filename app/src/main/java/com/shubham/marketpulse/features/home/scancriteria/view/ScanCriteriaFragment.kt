package com.shubham.marketpulse.features.home.scancriteria.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shubham.marketpulse.R
import com.shubham.marketpulse.base.BaseFragment
import com.shubham.marketpulse.features.home.HomeActivityViewModel
import com.shubham.marketpulse.features.home.scancriteria.ScanCriteriaRecyclerAdapter
import com.shubham.marketpulse.features.home.scancriteria.viewmodel.ScanCriteriaFragmentViewModel
import kotlinx.android.synthetic.main.fragment_scan_criteria.*
import kotlinx.android.synthetic.main.layout_scan_details.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
class ScanCriteriaFragment: BaseFragment(R.layout.fragment_scan_criteria) {

    private lateinit var homeActivityViewModel: HomeActivityViewModel
    private lateinit var viewModel: ScanCriteriaFragmentViewModel
    private var scanId: Int = 0
    private var adapter: ScanCriteriaRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        obtainDataBundle()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecycler()
        renderToolbar()
        renderScanCard()
        populateRecycler()
    }

    private fun setupViewModel() {
        try {
            homeActivityViewModel = requireActivity().let {
                ViewModelProvider(
                    it, viewModelFactory
                )[HomeActivityViewModel::class.java]
            }
        } catch (e: IllegalStateException) {}
        viewModel = ViewModelProvider(
            this, viewModelFactory
        )[ScanCriteriaFragmentViewModel::class.java]
    }

    private fun obtainDataBundle() {
        arguments?.let {
            scanId = ScanCriteriaFragmentArgs.fromBundle(it).scanId
        }
    }

    private fun configureRecycler() {
        if (adapter == null) {
            adapter = ScanCriteriaRecyclerAdapter()
        }
        rv_list?.let {
            with(it) {
                layoutManager = LinearLayoutManager(this.context)
                adapter = this@ScanCriteriaFragment.adapter
            }
        }
    }

    private fun renderToolbar() {
        iv_back?.visibility = View.VISIBLE
        iv_back?.setOnClickListener {
            activity?.onBackPressed()
        }
        tv_title?.visibility = View.VISIBLE
        tv_title?.text = getString(R.string.criteria_title)
    }

    private fun renderScanCard() {
        homeActivityViewModel.getScanDetails()?.let {
            tv_scan_title?.text = it.scanTitle
            return@let tv_scan_subtitle?.apply {
                text = it.scanSubtitle
                setTextColor(Color.parseColor(it.colorCode))
            }
        }
    }

    private fun populateRecycler() {
        if (homeActivityViewModel.getCriteriaDetails().isNotEmpty()) {
            adapter?.setData(homeActivityViewModel.getCriteriaDetails())
        }
    }
}