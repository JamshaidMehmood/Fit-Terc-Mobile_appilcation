package com.jamshaidsapplication.app.modules

typealias Welcome = ArrayList<Exercise1>

data class Exercise1 (
    val model: String,
    val pk: Long,
    val fields: Fields
)

data class Fields (
    val exercise_title: String,
    val duration: String,
    val reps: Long,
    val date: String
)

