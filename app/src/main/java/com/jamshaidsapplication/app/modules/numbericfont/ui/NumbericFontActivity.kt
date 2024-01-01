package com.jamshaidsapplication.app.modules.numbericfont.ui

import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityNumbericFontBinding
import com.jamshaidsapplication.app.modules.numbericfont.`data`.viewmodel.NumbericFontVM
import kotlin.String
import kotlin.Unit

class NumbericFontActivity :
    BaseActivity<ActivityNumbericFontBinding>(R.layout.activity_numberic_font) {
  private val viewModel: NumbericFontVM by viewModels<NumbericFontVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.numbericFontVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "NUMBERIC_FONT_ACTIVITY"

  }
}
