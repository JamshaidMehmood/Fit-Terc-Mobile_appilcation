package com.jamshaidsapplication.app.modules.home.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ExcersiseRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtThirtyFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_34)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMin: String? = MyApp.getInstance().resources.getString(R.string.lbl_min)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSkipping: String? = MyApp.getInstance().resources.getString(R.string.lbl_skipping)

)
