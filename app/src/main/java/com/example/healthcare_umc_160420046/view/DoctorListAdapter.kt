package com.example.healthcare_umc_160420046.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.model.Doctor
import com.example.healthcare_umc_160420046.util.loadImage

class DoctorListAdapter (private val doctorList:ArrayList<Doctor>): RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>() {
    class DoctorViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun updateDoctorList(newDoctorList:List<Doctor>){
        doctorList.clear()
        doctorList.addAll(newDoctorList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.doctor_list_item, parent,false)

        return DoctorViewHolder(v)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtMedicineName).text = doctorList[position].name
        holder.view.findViewById<TextView>(R.id.txtScheduleTime).text = doctorList[position].type
        holder.view.findViewById<RatingBar>(R.id.ratingBarDoctor).rating = doctorList[position].rating!!
        holder.view.findViewById<ImageView>(R.id.imgMedicineList).loadImage(doctorList[position].img.toString(), holder.view.findViewById(R.id.progressBar))

        holder.view.findViewById<Button>(R.id.btnSeeDetail).setOnClickListener {
            val doctorID = doctorList[position].id
            val action = DoctorListFragmentDirections.actionDoctorDetail(doctorID.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }
}