package com.jamshaidsapplication.app.modules.framesix.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.appcomponents.base.BaseActivity
import com.jamshaidsapplication.app.databinding.ActivityFrameSixBinding
import com.jamshaidsapplication.app.modules.Exercise
import com.jamshaidsapplication.app.modules.Exercise1
import com.jamshaidsapplication.app.modules.framesix.data.viewmodel.FrameSixVM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jamshaidsapplication.app.modules.ExerciseAdapter

class FrameSixActivity : BaseActivity<ActivityFrameSixBinding>(R.layout.activity_frame_six) {
  private val viewModel: FrameSixVM by viewModels<FrameSixVM>()
  // for recyclerView
  private lateinit var recyclerView: RecyclerView
  private lateinit var exerciseAdapter: ExerciseAdapter


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frameSixVM = viewModel
    // Initialize RecyclerView
    recyclerView = findViewById(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(this)
    exerciseAdapter = ExerciseAdapter(this)
    recyclerView.adapter = exerciseAdapter
    // fetch data from server
    fetchExerciseFromServer()
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "FRAME_SIX_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FrameSixActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

//    fun getInstance(bundle: Bundle?): FrameSixActivity {
//      val fragment = FrameSixActivity()
//      fragment.arguments = bundle
//      return fragment
//    }

  }

//  FUNCTION FOR EXTRACTING RECORDS ROM DJANGO SERVER

  private fun fetchExerciseFromServer() {
    val api: Exercise =Retrofit.Builder()
      .baseUrl("http://192.168.43.5:8000")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(Exercise::class.java)

    api.getAllExercise().enqueue(object : Callback<List<Exercise1>> {
      override fun onResponse(call: Call<List<Exercise1>>, response: Response<List<Exercise1>>) {
        if (response.isSuccessful) {
          val exercises = response.body()
          exerciseAdapter.setExercises(exercises)
          //exerciseAdapter?.setExercises(exercises)
          if (exercises != null) {
            for (exercise in exercises) {
              Log.d("MainActivityF", "Exercise Name: ${exercise.fields.exercise_title}")
              Log.d("MainActivityF", "Duration: ${exercise.fields.duration}")
              Log.d("MainActivityF", "Reps: ${exercise.fields.reps}")
              Log.d("MainActivityF", "Date: ${exercise.fields.date}")
            }
          } else {
            Log.d("MainActivityF", "No books found")
          }
        } else {
          Log.d("MainActivityF", "Request failed: ${response.code()}")
        }

      }
      override fun onFailure(call: Call<List<Exercise1>>, t: Throwable?) {
        // Handle network error
        Log.e("MainActivityF", "Error getting exercise", t)
      }
    })
  }

}
