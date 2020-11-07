package com.shubham.marketpulse.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.shubham.marketpulse.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
class MarketPulseApplication: Application(), HasAndroidInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.factory().create(this).inject(this)
    }
}