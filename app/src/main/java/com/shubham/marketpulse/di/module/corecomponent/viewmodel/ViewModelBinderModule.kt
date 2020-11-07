package com.shubham.marketpulse.di.module.corecomponent.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.shubham.marketpulse.utility.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module
abstract class ViewModelBinderModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}