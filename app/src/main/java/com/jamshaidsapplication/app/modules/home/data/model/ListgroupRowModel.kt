package com.jamshaidsapplication.app.modules.home.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ListgroupRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_05_00_am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeOne: String? = MyApp.getInstance().resources.getString(R.string.msg_jogging_for_30)

)
