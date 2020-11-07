package com.shubham.marketpulse.di.module.corecomponent.fragment

import com.shubham.marketpulse.features.home.scancriteria.view.ScanCriteriaFragment
import com.shubham.marketpulse.features.home.scanslisting.view.ScansListingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by shubhampatel on 08 Nov, 2020.
 */
@Module
abstract class HomeFragmentsModule {

    @ContributesAndroidInjector
    internal abstract fun contributeScansListingFragment(): ScansListingFragment

    @ContributesAndroidInjector
    internal abstract fun contributeScanCriteriaFragment(): ScanCriteriaFragment
}