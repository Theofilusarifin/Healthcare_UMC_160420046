package com.example.healthcare_umc_160420046.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.model.Schedule

class DoctorScheduleAdapter (private val scheduleList:ArrayList<Schedule>): RecyclerView.Adapter<DoctorScheduleAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun updateScheduleList(newScheduleList:List<Schedule>){
        scheduleList.clear()
        scheduleList.addAll(newScheduleList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.doctor_schedule_item, parent,false)

        return ScheduleViewHolder(v)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtMedicineName).text = scheduleList[position].day
        holder.view.findViewById<TextView>(R.id.txtScheduleTime).text = scheduleList[position].time
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }
}