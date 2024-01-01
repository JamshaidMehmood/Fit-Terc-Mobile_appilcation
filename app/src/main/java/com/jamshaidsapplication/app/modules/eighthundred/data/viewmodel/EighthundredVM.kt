package com.jamshaidsapplication.app.modules.eighthundred.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.eighthundred.`data`.model.EighthundredModel
import org.koin.core.KoinComponent

class EighthundredVM : ViewModel(), KoinComponent {
  val eighthundredModel: MutableLiveData<EighthundredModel> = MutableLiveData(EighthundredModel())

  var navArguments: Bundle? = null
}
