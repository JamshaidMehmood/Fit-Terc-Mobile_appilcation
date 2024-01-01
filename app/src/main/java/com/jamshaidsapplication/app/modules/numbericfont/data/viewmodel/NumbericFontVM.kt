package com.jamshaidsapplication.app.modules.numbericfont.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.numbericfont.`data`.model.NumbericFontModel
import org.koin.core.KoinComponent

class NumbericFontVM : ViewModel(), KoinComponent {
  val numbericFontModel: MutableLiveData<NumbericFontModel> = MutableLiveData(NumbericFontModel())

  var navArguments: Bundle? = null
}
