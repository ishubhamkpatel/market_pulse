package com.shubham.marketpulse.features.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.shubham.marketpulse.R
import com.shubham.marketpulse.base.BaseActivity
import com.shubham.marketpulse.features.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity(R.layout.activity_splash) {

    companion object {
        private const val WAITING_DURATION = 5000L // 5 seconds
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        waitAndLaunchHome()
    }

    private fun waitAndLaunchHome() {
        lifecycleScope.launch {
            delay(WAITING_DURATION)
            launchHome()
        }
    }

    private fun launchHome() {
        val intent = Intent(this, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
        finish()
    }
}