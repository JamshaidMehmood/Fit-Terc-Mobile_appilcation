package com.jamshaidsapplication.app.modules.tasks.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamshaidsapplication.app.modules.tasks.`data`.model.TasksModel
import org.koin.core.KoinComponent

class TasksVM : ViewModel(), KoinComponent {
  val tasksModel: MutableLiveData<TasksModel> = MutableLiveData(TasksModel())

  var navArguments: Bundle? = null
}
