package com.jamshaidsapplication.app.modules.home.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.home.`data`.model.ExcersiseRowModel
import com.jamshaidsapplication.app.modules.home.`data`.model.HomeModel
import com.jamshaidsapplication.app.modules.home.`data`.model.ListgroupRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class HomeVM : ViewModel(), KoinComponent {
  val homeModel: MutableLiveData<HomeModel> = MutableLiveData(HomeModel())

  var navArguments: Bundle? = null

  val listgroupList: MutableLiveData<MutableList<ListgroupRowModel>> =
      MutableLiveData(mutableListOf())

  val excersiseList: MutableLiveData<MutableList<ExcersiseRowModel>> =
      MutableLiveData(mutableListOf())
}
