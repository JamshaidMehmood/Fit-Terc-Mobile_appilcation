package com.jamshaidsapplication.app.modules.colors.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ColorsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtColors: String? = MyApp.getInstance().resources.getString(R.string.lbl_colors)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrimaryGrey: String? = MyApp.getInstance().resources.getString(R.string.lbl_primary_grey)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSecondaryGrey: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_secondary_grey)

)
