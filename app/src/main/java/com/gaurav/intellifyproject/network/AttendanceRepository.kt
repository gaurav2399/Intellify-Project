package com.gaurav.intellifyproject.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.gaurav.intellifyproject.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// for communicating with data source and view Model
class AttendanceRepository {

    // for creating Api Service
    private var apiService: AttendanceApi = AttendanceApi()

    init{
        Log.e("service created","success")
    }

    fun getApiAttendance(studentId:String,context: Context):MutableLiveData<ApiResponse>{
        val attendanceData:MutableLiveData<ApiResponse> = MutableLiveData()
        val service = apiService.getAttendance(studentId)

        // sending request to api and give us response
        service.enqueue(object : Callback<ApiResponse>{

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("sending request","failed")
                Toast.makeText(context,"sending request failed",Toast.LENGTH_SHORT).show()
                attendanceData.value = null
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                Log.e("sending request","success")
                if(response.isSuccessful){
                    attendanceData.value = response.body()
                    Toast.makeText(context,"getting response success",Toast.LENGTH_SHORT).show()
                }else{
                    if(response.code() == 400) {
                        Log.e("getting response", "error")
                        Log.e("error", response.message())
                        Toast.makeText(context, "Error : ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        })

        return attendanceData
    }

}