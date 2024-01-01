package com.jamshaidsapplication.app.modules.ExerciseActivity.kt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.modules.Exercise
import com.jamshaidsapplication.app.modules.homecontainer.ui.HomeContainerActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExercisesActivity : AppCompatActivity() {

    //    lateinit var id1: EditText
    lateinit var editExercise1: EditText
    lateinit var durationTextView1: EditText
    lateinit var repsTextView1: EditText
    lateinit var dateTextView1: EditText
    lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_exercise)
        Log.d("Exerciseeeee", "In Edit  Exercise Activity")

        editExercise1 = findViewById(R.id.editExerciseTitle1)
        durationTextView1 = findViewById(R.id.editDuration1)
        repsTextView1 = findViewById(R.id.editReps1)
        dateTextView1 = findViewById(R.id.editDate1)
        btnUpdate = findViewById(R.id.btnUpdate)

        // Retrieve values from the Intent's extras
        val id: Int = intent.getIntExtra("id", 0)
        val title = intent.getStringExtra("title")
        val duration = intent.getStringExtra("duration")
        val reps = intent.getStringExtra("reps")
        val date = intent.getStringExtra("date")

        Log.d("Dataaaa", "{$id,$title,$duration,$reps,$date}")
        // Set values to the EditText fields
        editExercise1.setText(title)
        durationTextView1.setText(duration)
        repsTextView1.setText(reps)
        dateTextView1.setText(date)

        // Set up the click listener for the "Update" button
        btnUpdate.setOnClickListener {
            if (reps != null) {
                if (duration != null) {
                    if (title != null) {
                        if (date != null) {
                            onUpdateButtonClick(id,title,duration,reps,date)
                        }
                    }
                }
            }
        }
    }

    private fun onUpdateButtonClick(id: Int,title: String , duration :String , reps : String , date :String) {
        // Retrieve updated values
        val updatedTitle = editExercise1.text.toString()
        val updatedDuration = durationTextView1.text.toString()
        val updatedReps = repsTextView1.text.toString()
        val updatedDate = dateTextView1.text.toString()


        // Perform the necessary actions with updated values (e.g., update the data in your database)
        Log.d("Jamshaid ", "$updatedTitle , $updatedDuration , $updatedReps , $updatedDate")

        Log.d("Jam","Near the API")
        val api: Exercise = Retrofit.Builder()
            .baseUrl("http://192.168.43.5:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Exercise::class.java)

        Log.d("J.18","After the API")
        val call = api.updateExercise(id,updatedTitle,updatedDuration,updatedReps,updatedDate)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.code()==200) {
                    val responseBody = response.body()
                    Log.d("YourActivity", "Response Body: $responseBody")
                } else {
                    Log.d("YourActivity", "Request failed: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                // Handle network error
                Log.e("MainActivityF", "Error in Updating exercise", t)
            }
        })
        val intent = Intent(this@ExercisesActivity, HomeContainerActivity::class.java)
        ContextCompat.startActivity(this@ExercisesActivity, intent, null)
    }
}
