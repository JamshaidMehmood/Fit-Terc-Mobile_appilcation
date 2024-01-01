package com.jamshaidsapplication.app.modules.eighthundred.ui

import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityEighthundredBinding
import com.jamshaidsapplication.app.modules.eighthundred.`data`.viewmodel.EighthundredVM
import kotlin.String
import kotlin.Unit

class EighthundredActivity :
    BaseActivity<ActivityEighthundredBinding>(R.layout.activity_eighthundred) {
  private val viewModel: EighthundredVM by viewModels<EighthundredVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.eighthundredVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "EIGHTHUNDRED_ACTIVITY"

  }
}
