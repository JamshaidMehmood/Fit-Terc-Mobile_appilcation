package com.jamshaidsapplication.app.modules.numbericfont.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class NumbericFontModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTypography: String? = MyApp.getInstance().resources.getString(R.string.lbl_typography)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArcivoBlack: String? = MyApp.getInstance().resources.getString(R.string.lbl_bebas_neue)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeading136: String? = MyApp.getInstance().resources.getString(R.string.lbl_heading_1_36)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeading230: String? = MyApp.getInstance().resources.getString(R.string.lbl_heading_2_30)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeading324: String? = MyApp.getInstance().resources.getString(R.string.lbl_heading_3_24)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeading420: String? = MyApp.getInstance().resources.getString(R.string.lbl_heading_4_20)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeading518: String? = MyApp.getInstance().resources.getString(R.string.lbl_heading_5_18)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeading616: String? = MyApp.getInstance().resources.getString(R.string.lbl_heading_6_16)

)
