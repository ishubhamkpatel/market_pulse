package com.shubham.marketpulse.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created by shubhampatel on 07 Nov, 2020.
 */
abstract class BaseFragment(@LayoutRes id: Int): Fragment(id) {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}