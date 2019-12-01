package com.gaurav.intellifyproject.model

data class ApiResponse(
    val message:String? = null,
    val attendance: List<Attendance>? = null
)