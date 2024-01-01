package com.jamshaidsapplication.app.modules.sixhundred.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.sixhundred.`data`.model.SixhundredModel
import org.koin.core.KoinComponent

class SixhundredVM : ViewModel(), KoinComponent {
  val sixhundredModel: MutableLiveData<SixhundredModel> = MutableLiveData(SixhundredModel())

  var navArguments: Bundle? = null
}
