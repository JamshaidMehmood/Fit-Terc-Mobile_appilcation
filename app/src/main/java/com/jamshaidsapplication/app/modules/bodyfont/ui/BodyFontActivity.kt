package com.jamshaidsapplication.app.modules.bodyfont.ui

import android.view.View
import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityBodyFontBinding
import com.jamshaidsapplication.app.modules.bodyfont.`data`.model.BodyFontRowModel
import com.jamshaidsapplication.app.modules.bodyfont.`data`.viewmodel.BodyFontVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class BodyFontActivity : BaseActivity<ActivityBodyFontBinding>(R.layout.activity_body_font) {
  private val viewModel: BodyFontVM by viewModels<BodyFontVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val bodyFontAdapter = BodyFontAdapter(viewModel.bodyFontList.value?:mutableListOf())
    binding.recyclerBodyFont.adapter = bodyFontAdapter
    bodyFontAdapter.setOnItemClickListener(
    object : BodyFontAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : BodyFontRowModel) {
        onClickRecyclerBodyFont(view, position, item)
      }
    }
    )
    viewModel.bodyFontList.observe(this) {
      bodyFontAdapter.updateData(it)
    }
    binding.bodyFontVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerBodyFont(
    view: View,
    position: Int,
    item: BodyFontRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "BODY_FONT_ACTIVITY"

  }
}
