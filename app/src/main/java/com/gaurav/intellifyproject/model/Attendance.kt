package com.gaurav.intellifyproject.model

data class Attendance(
    val className:String? = null,
    val totalLectures:Int = 0,
    val present:Int = 0 ,
    val sick:Int = 0,
    val absent:Int = 0,
    val late:Int =0
)