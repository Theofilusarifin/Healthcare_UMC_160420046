package com.example.healthcare_umc_160420046.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.model.Medicine
import com.example.healthcare_umc_160420046.util.loadImage

class MedicineListAdapter (private val medicineList:ArrayList<Medicine>): RecyclerView.Adapter<MedicineListAdapter.MedicineViewHolder>() {
    class MedicineViewHolder(val view: View): RecyclerView.ViewHolder(view)

    fun updateDoctorList(newMedicineList:List<Medicine>){
        medicineList.clear()
        medicineList.addAll(newMedicineList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.medicine_list_item, parent,false)

        return MedicineViewHolder(v)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtMedicineName).text = medicineList[position].name
        holder.view.findViewById<TextView>(R.id.txtPrice).text = "Rp.${medicineList[position].price.toString()}"
        holder.view.findViewById<ImageView>(R.id.imgMedicineList).loadImage(medicineList[position].img.toString(), holder.view.findViewById(R.id.progressBar))

        holder.view.findViewById<Button>(R.id.btnMedicineDetail).setOnClickListener {
            val medicineID = medicineList[position].id
            val action = MedicineListFragmentDirections.actionMedicineDetail(medicineID.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }


    override fun getItemCount(): Int {
        return medicineList.size
    }
}