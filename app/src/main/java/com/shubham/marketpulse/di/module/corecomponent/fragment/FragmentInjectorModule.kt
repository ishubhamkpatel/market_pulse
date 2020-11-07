package com.shubham.marketpulse.di.module.corecomponent.fragment

import com.shubham.marketpulse.base.BaseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module
abstract class FragmentInjectorModule {

    @ContributesAndroidInjector
    internal abstract fun contributeBaseFragment(): BaseFragment
}