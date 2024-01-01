package com.jamshaidsapplication.app.modules

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Exercise {
    @GET("sdb/addExercise")
    fun addExercise(
        @Query("exercise_title") title: String,
        @Query("duration") duration: String,
        @Query("reps") reps: String,
        @Query("date") date: String,
    ): Call<Void>

    @GET("sdb/allExercise")
    fun getAllExercise(): Call<List<Exercise1>>

//    @GET("sdb/delExercise")
//    fun deleteExercise(@Query("exercise") name: CharSequence, @Query("date") date: CharSequence,):Call<String>
@GET("sdb/delExercise")
fun deleteExercise(@Query("id") id: Int,):Call<String>


    @GET("sdb/updateExercise")
    fun updateExercise(
        @Query("pk") id: Int ?,
        @Query("title") title: String,
        @Query("duration") duration: String,
        @Query("reps") reps: String,
        @Query("date") date: String
    ): Call<String>
}