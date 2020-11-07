package com.shubham.marketpulse.di.module.corecomponent.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.marketpulse.di.qualifier.ViewModelKey
import com.shubham.marketpulse.features.home.HomeActivityViewModel
import com.shubham.marketpulse.features.home.scancriteria.viewmodel.ScanCriteriaFragmentViewModel
import com.shubham.marketpulse.features.home.scanslisting.viewmodel.ScansListingFragmentViewModel
import com.shubham.marketpulse.utility.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module
abstract class ViewModelBinderModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    internal abstract fun bindHomeActivityViewModel(homeActivityViewModel: HomeActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScansListingFragmentViewModel::class)
    internal abstract fun bindScansListingFragmentViewModel(scansListingFragmentViewModel: ScansListingFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ScanCriteriaFragmentViewModel::class)
    internal abstract fun bindScanCriteriaFragmentViewModel(scanCriteriaFragmentViewModel: ScanCriteriaFragmentViewModel): ViewModel
}