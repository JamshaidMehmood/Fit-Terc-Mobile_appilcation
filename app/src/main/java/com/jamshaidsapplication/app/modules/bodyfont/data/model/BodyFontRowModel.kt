package com.jamshaidsapplication.app.modules.bodyfont.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class BodyFontRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtH130: String? = MyApp.getInstance().resources.getString(R.string.lbl_h1_30)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtH130One: String? = MyApp.getInstance().resources.getString(R.string.lbl_h1_30)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtH130Two: String? = MyApp.getInstance().resources.getString(R.string.lbl_h1_30)

)
