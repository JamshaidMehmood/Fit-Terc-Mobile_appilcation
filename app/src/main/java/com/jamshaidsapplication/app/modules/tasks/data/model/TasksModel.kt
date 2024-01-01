package com.jamshaidsapplication.app.modules.tasks.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class TasksModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAddExercise: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_exercise)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFrame126Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etFrame126OneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etFrame126TwoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etFrame126ThreeValue: String? = null
)
