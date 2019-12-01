package com.gaurav.intellifyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gaurav.intellifyproject.adapters.AttendanceAdapter
import com.gaurav.intellifyproject.model.Attendance
import com.gaurav.intellifyproject.viewmodels.AttendanceViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var attendanceArrayList: MutableList<Attendance> = ArrayList()
    private var attendanceAdapter: AttendanceAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // attaching view Model class
        val attendanceViewModel = ViewModelProviders.of(this).get(AttendanceViewModel::class.java)

        // functionality for button
        getAttendance.setOnClickListener {


            attendanceViewModel.getAttendance(stud_id.text.toString(),this)?.observe(this, Observer{ attendanceResponse ->
                val attendanceList = attendanceResponse.attendance
                attendanceArrayList.addAll(attendanceList!!)
                attendanceAdapter?.notifyDataSetChanged()
            })

            //setting recycler view
            setUpRecyclerView()
        }
    }

    private fun setUpRecyclerView() {
        if (attendanceAdapter == null) {
            attendanceAdapter =
                AttendanceAdapter(this@MainActivity, attendanceArrayList)
            attendanceRecyclerList.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = attendanceAdapter
                isNestedScrollingEnabled = true
            }
        } else {
            attendanceAdapter!!.notifyDataSetChanged()
        }

    }
}
