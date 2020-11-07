package com.shubham.marketpulse.di.module

import android.content.Context
import com.shubham.marketpulse.application.MarketPulseApplication
import com.shubham.marketpulse.di.module.corecomponent.activity.ActivityInjectorModule
import com.shubham.marketpulse.di.module.corecomponent.fragment.FragmentInjectorModule
import com.shubham.marketpulse.di.module.corecomponent.viewmodel.ViewModelBinderModule
import com.shubham.marketpulse.di.module.data.DataProviderModule
import com.shubham.marketpulse.di.module.extcomponent.ExtComponentProviderModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Module(
    includes = [
        ActivityInjectorModule::class,
        FragmentInjectorModule::class,
        ViewModelBinderModule::class,
        DataProviderModule::class,
        ExtComponentProviderModule::class
    ]
)
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(
        application: MarketPulseApplication
    ): Context = application.applicationContext
}