package com.gaurav.intellifyproject.network

import com.gaurav.intellifyproject.model.ApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6ODM2ODgwNTkwM30.sQisPnG7Iorhdp-5i6wLpu4GZtedwaMbXtf2y6kcnEc"

interface AttendanceApi {

    // making get request for api
    @Headers("Cookie: token=$token")
    @GET("api/attendance?for=AllClassAttendance")
    fun getAttendance(
        @Query("student_id") id:String? = null
    ):Call<ApiResponse>

    // static object
    companion object{
        // on invocation automatically runs
        operator fun invoke(): AttendanceApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://services.intellify.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AttendanceApi::class.java)
        }
    }

}