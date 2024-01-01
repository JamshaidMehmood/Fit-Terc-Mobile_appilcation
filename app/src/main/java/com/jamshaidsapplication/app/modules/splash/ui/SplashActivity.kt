package com.jamshaidsapplication.app.modules.splash.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivitySplashBinding
import com.jamshaidsapplication.app.modules.homecontainer.ui.HomeContainerActivity
import com.jamshaidsapplication.app.modules.splash.`data`.viewmodel.SplashVM
import kotlin.String
import kotlin.Unit

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
  private val viewModel: SplashVM by viewModels<SplashVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.frame01splash.setOnClickListener {
        val destIntent = HomeContainerActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "SPLASH_ACTIVITY"

    }
  }
