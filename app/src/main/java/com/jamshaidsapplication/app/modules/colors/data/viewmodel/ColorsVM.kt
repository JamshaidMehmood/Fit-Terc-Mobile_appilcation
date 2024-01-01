package com.jamshaidsapplication.app.modules.colors.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.colors.`data`.model.ColorsModel
import org.koin.core.KoinComponent

class ColorsVM : ViewModel(), KoinComponent {
  val colorsModel: MutableLiveData<ColorsModel> = MutableLiveData(ColorsModel())

  var navArguments: Bundle? = null
}
