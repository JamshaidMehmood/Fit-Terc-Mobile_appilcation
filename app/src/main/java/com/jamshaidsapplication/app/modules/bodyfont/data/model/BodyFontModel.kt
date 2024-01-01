package com.jamshaidsapplication.app.modules.bodyfont.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class BodyFontModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtInter: String? = MyApp.getInstance().resources.getString(R.string.lbl_circular_std)

)
