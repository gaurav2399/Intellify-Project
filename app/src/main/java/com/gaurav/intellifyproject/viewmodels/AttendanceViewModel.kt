package com.gaurav.intellifyproject.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gaurav.intellifyproject.model.ApiResponse
import com.gaurav.intellifyproject.network.AttendanceRepository

// view model for survive configuration changes
// manage ui related data
class AttendanceViewModel :ViewModel() {
    private var mutableLiveData:MutableLiveData<ApiResponse>? = null

    // communicate data source through repository
    private var attendanceRepository: AttendanceRepository =
        AttendanceRepository()

    fun getAttendance(stud_id:String = "1",context: Context):MutableLiveData<ApiResponse>?{
        mutableLiveData = attendanceRepository.getApiAttendance(stud_id,context)
        return mutableLiveData
    }
}