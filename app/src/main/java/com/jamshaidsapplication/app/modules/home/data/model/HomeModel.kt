package com.jamshaidsapplication.app.modules.home.`data`.model

import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHello: String? = MyApp.getInstance().resources.getString(R.string.lbl_hello)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtJAMSHAID: String? = MyApp.getInstance().resources.getString(R.string.lbl_akshay_syal)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt3524: String? = MyApp.getInstance().resources.getString(R.string.lbl_3_524)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSteps: String? = MyApp.getInstance().resources.getString(R.string.lbl_steps)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNineHundredFiftyTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_952)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCalories: String? = MyApp.getInstance().resources.getString(R.string.lbl_calories)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt1219: String? = MyApp.getInstance().resources.getString(R.string.lbl_12_19)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCoins: String? = MyApp.getInstance().resources.getString(R.string.lbl_coins)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDistance: String? = MyApp.getInstance().resources.getString(R.string.lbl_2_4_km)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDistanceOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_distance)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtThirtyEight: String? = MyApp.getInstance().resources.getString(R.string.lbl_38)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeartbeat: String? = MyApp.getInstance().resources.getString(R.string.lbl_heart_beat)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMyAlarmPlans: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_my_alarm_plans)

)
