package com.jamshaidsapplication.app.modules

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.RecyclerView
import com.jamshaidsapplication.app.R
import com.jamshaidsapplication.app.modules.ExerciseActivity.kt.ExercisesActivity
import com.jamshaidsapplication.app.modules.framesix.ui.FrameSixActivity
import com.jamshaidsapplication.app.modules.homecontainer.ui.HomeContainerActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ExerciseAdapter(private val context: Context) : RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    private var exercise: List<Exercise1>? = null


    fun setExercises(exercises: List<Exercise1>?) {
        this.exercise = exercises
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exercises, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exer = exercise?.get(position)
        if (exer != null) {
            holder.bind(exer)
        }
    }

    override fun getItemCount(): Int {
        return exercise?.size ?: 0
    }


    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: String = ""
        var date: String = ""
        var duration : String = ""
        var reps : String = ""
        var id : Int = 0

        // Find views by their IDs
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val durationTextView: TextView = itemView.findViewById(R.id.durationTextView)
        val repsTextView: TextView = itemView.findViewById(R.id.repsTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val delButton: Button = itemView.findViewById(R.id.delButton)
        val editButtonClicked: AppCompatButton = itemView.findViewById(R.id.editButton)
        // for image button of the edit activity
//        val backButton :ImageButton = itemView.findViewById(R.id.imageBack1)

        //--------------------------------------
        init {
            // for delete button
            delButton.setOnClickListener {
                onDeleteClickListener(adapterPosition)
            }
            editButtonClicked.setOnClickListener {
                editButtonClickListener(adapterPosition)
            }
//            backButton.setOnClickListener{
//                val intent = Intent(itemView.context, FrameSixActivity::class.java)
//                startActivity(itemView.context, intent, null)
//            }
        }

        fun bind(exercise: Exercise1) {
            // Set data to the views
            id = exercise.pk.toInt();
            title = exercise.fields.exercise_title;
            duration = exercise.fields.duration
            date = exercise.fields.date;
            reps = exercise.fields.reps.toString();

            // for showing in the recycler View
            titleTextView.text = "Title: ${exercise.fields.exercise_title}"
            durationTextView.text = "Duration: ${exercise.fields.duration}"
            repsTextView.text = "Reps: ${exercise.fields.reps}"
            dateTextView.text = "Date: ${exercise.fields.date}"

        }

        // on click listner function
        private fun onDeleteClickListener(adapterPosition: Int) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                Log.d("YourActivity",  "Data is as $title  , $date")

                if (titleTextView.text != null && dateTextView.text != null) {
                    val api: Exercise = Retrofit.Builder()
                        .baseUrl("http://192.168.43.5:8000")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Exercise::class.java)

                    //val call = api.deleteExercise(title,date)
                    val call = api.deleteExercise(id)
                    call.enqueue(object : Callback<String>{
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            if (response.code()==200) {
                                val responseBody = response.body()
                                Log.d("YourActivity", "Response Body: $responseBody")
                                val intent = Intent(itemView.context, HomeContainerActivity::class.java)
                                startActivity(itemView.context, intent, null)

                            } else {
                                Log.d("YourActivity", "Request failed: ${response.code()}")
                            }
                        }

                        override fun onFailure(call: Call<String>, t: Throwable) {
                            // Handle network error
                            Log.e("MainActivityF", "Error in deleting exercise", t)
                        }
                    })
                }
                val intent = Intent(itemView.context, HomeContainerActivity::class.java)
                startActivity(itemView.context, intent, null)
            }
        }

        // for edit button functionality
        private fun editButtonClickListener(adapterPosition: Int) {
            if (adapterPosition != RecyclerView.NO_POSITION) {

                val id= id
                val title = title
                val duration = duration
                val reps = reps
                val date = date
                //----------------------
                Log.d("Exerciseeeee","In ExerciseAdapter")
                val intent = Intent(itemView.context, ExercisesActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("title", title)
                intent.putExtra("duration", duration)
                intent.putExtra("reps", reps)
                intent.putExtra("date", date)

                // Start the activity with the created Intent
                startActivity(itemView.context, intent, null)
                Log.d("Exerciseeeee","After ExerciseAdapter")
                }

        }
    }
}