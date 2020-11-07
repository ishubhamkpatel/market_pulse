package com.shubham.marketpulse.di.module.corecomponent.activity

import com.shubham.marketpulse.base.BaseActivity
import com.shubham.marketpulse.features.home.HomeActivity
import com.shubham.marketpulse.features.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module
abstract class ActivityInjectorModule {

    @ContributesAndroidInjector
    internal abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    internal abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    internal abstract fun contributeHomeActivity(): HomeActivity
}