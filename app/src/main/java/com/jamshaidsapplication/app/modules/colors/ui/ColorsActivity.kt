package com.jamshaidsapplication.app.modules.colors.ui

import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityColorsBinding
import com.jamshaidsapplication.app.modules.colors.`data`.viewmodel.ColorsVM
import kotlin.String
import kotlin.Unit

class ColorsActivity : BaseActivity<ActivityColorsBinding>(R.layout.activity_colors) {
  private val viewModel: ColorsVM by viewModels<ColorsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.colorsVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "COLORS_ACTIVITY"

  }
}
