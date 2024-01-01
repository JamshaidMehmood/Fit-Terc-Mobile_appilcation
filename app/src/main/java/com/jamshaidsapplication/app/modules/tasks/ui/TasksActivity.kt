package com.jamshaidsapplication.app.modules.tasks.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityTasksBinding
import com.jamshaidsapplication.app.modules.Exercise
import com.jamshaidsapplication.app.modules.framesix.ui.FrameSixActivity
import com.jamshaidsapplication.app.modules.homecontainer.ui.HomeContainerActivity
import com.jamshaidsapplication.app.modules.tasks.data.viewmodel.TasksVM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat

class TasksActivity : BaseActivity<ActivityTasksBinding>(R.layout.activity_tasks) {
  private val viewModel: TasksVM by viewModels<TasksVM>()

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.tasksVM = viewModel
  }

  // for saving data in the database server
  private val api: Exercise = Retrofit.Builder()
    .baseUrl("http://192.168.43.5:8000")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(Exercise::class.java)

  override fun setUpClicks() {
    binding.btnSave.setOnClickListener {
      val title = binding.editExerciseTitle.text.toString()
      val duration = binding.editDuration.text.toString()
      val reps = binding.editReps.text.toString()
      val date = binding.editDate.text.toString()

      if (title.isEmpty() || duration.isEmpty() || reps.isEmpty() || date.isEmpty() ) {
        Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
        return@setOnClickListener
      }

      // Check if the date format is valid
      if (!isDateFormatValid(date)) {
        Toast.makeText(this, "Invalid date format. Use YYYY-MM-DD", Toast.LENGTH_LONG).show()
        return@setOnClickListener
      }

      val call = api.addExercise(
        title, duration, reps, date
      )

      call.enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>, response: Response<Void>) {
          if (response.isSuccessful) {
            var success = 1
            Log.d("YourActivity", "Success: $success")
          } else {
            Log.d("Failure in activity", "Success: 0")
          }
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
          // Handle network error
          Log.e("MainActivityF", "Error in saving exercise", t)
        }

      })
      Toast.makeText(this, "Exercise Inserted successfully", Toast.LENGTH_SHORT).show()
      val destIntent = FrameSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.imageBack.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }


  // Function to check if the date format is valid
  private fun isDateFormatValid(dateString: String): Boolean {
    val dateFormatPattern = "yyyy-MM-dd"
    val simpleDateFormat = SimpleDateFormat(dateFormatPattern)
    simpleDateFormat.isLenient = false

    return try {
      val parsedDate = simpleDateFormat.parse(dateString)
      parsedDate != null
    } catch (e: Exception) {
      false
    }
  }


  companion object {
    val TAG: String = "TASKS_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, TasksActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
