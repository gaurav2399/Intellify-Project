package com.gaurav.intellifyproject.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.gaurav.intellifyproject.model.Attendance
import com.gaurav.intellifyproject.R
import org.w3c.dom.Text
import java.text.DecimalFormat


class AttendanceAdapter(private val context:Context, private val attendanceList:MutableList<Attendance>): RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        // attach layout
        val view = LayoutInflater.from(context).inflate(R.layout.attendance_item, parent, false)
        return AttendanceViewHolder(view)
    }

    override fun getItemCount(): Int = attendanceList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        attendanceList[position].apply {
            val presentLectures: Int = this.present
            val totalLectures:Int = this.totalLectures
            Log.e("presentLectures",presentLectures.toString())
            Log.e("total Lectures",totalLectures.toString())
            val percent = (presentLectures.toFloat()/totalLectures.toFloat()) * 100
            val decimalFormat = DecimalFormat("##.##")
            Log.e("coming percent",decimalFormat.format(percent))
            holder.attendance.text = "${decimalFormat.format(percent)}%"
            holder.className.text = this.className
            holder.totalLectures.text = this.totalLectures.toString()
            holder.present.text = this.present.toString()
            holder.absent.text = this.absent.toString()
        }
    }

    class AttendanceViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val className: TextView = view.findViewById(R.id.className)
        val attendance: TextView = view.findViewById(R.id.attendance)
        val totalLectures: TextView = view.findViewById(R.id.totalLectures)
        val present:TextView = view.findViewById(R.id.present)
        val absent:TextView = view.findViewById(R.id.absent)
    }

}