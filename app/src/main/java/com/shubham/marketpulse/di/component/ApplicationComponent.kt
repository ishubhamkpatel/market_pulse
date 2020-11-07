package com.shubham.marketpulse.di.component

import com.shubham.marketpulse.application.MarketPulseApplication
import com.shubham.marketpulse.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MarketPulseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MarketPulseApplication): ApplicationComponent
    }

    override fun inject(instance: MarketPulseApplication?)
}