package com.jamshaidsapplication.app.modules.sixhundred.ui

import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivitySixhundredBinding
import com.jamshaidsapplication.app.modules.sixhundred.`data`.viewmodel.SixhundredVM
import kotlin.String
import kotlin.Unit

class SixhundredActivity : BaseActivity<ActivitySixhundredBinding>(R.layout.activity_sixhundred) {
  private val viewModel: SixhundredVM by viewModels<SixhundredVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.sixhundredVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SIXHUNDRED_ACTIVITY"

  }
}
