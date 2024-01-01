package com.jamshaidsapplication.app.modules.bodyfont.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.bodyfont.`data`.model.BodyFontModel
import com.jamshaidsapplication.app.modules.bodyfont.`data`.model.BodyFontRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class BodyFontVM : ViewModel(), KoinComponent {
  val bodyFontModel: MutableLiveData<BodyFontModel> = MutableLiveData(BodyFontModel())

  var navArguments: Bundle? = null

  val bodyFontList: MutableLiveData<MutableList<BodyFontRowModel>> =
      MutableLiveData(mutableListOf())
}
