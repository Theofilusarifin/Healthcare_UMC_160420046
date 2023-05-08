package com.example.healthcare_umc_160420046.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.util.loadImage
import com.example.healthcare_umc_160420046.viewmodel.DoctorDetailViewModel

class DoctorDetailFragment : Fragment() {
    private lateinit var viewModel: DoctorDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doctor_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val doctorID = DoctorDetailFragmentArgs.fromBundle(requireArguments()).doctorID.toString()
        Log.d("Doctor ID", doctorID)
        viewModel = ViewModelProvider(this)[DoctorDetailViewModel::class.java]
        viewModel.fetch(doctorID)

        observeViewModel()

        val btnSeeSchedule = view.findViewById<Button>(R.id.btnSeeSchedule)
        btnSeeSchedule.setOnClickListener {
            val action = DoctorDetailFragmentDirections.actionDoctorSchedule(doctorID)
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeViewModel() {
        viewModel.doctorLD.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextView>(R.id.txtMedicineNameDetail)?.text = it.name
            view?.findViewById<TextView>(R.id.txtSpecialistDetail)?.text = it.type
            view?.findViewById<RatingBar>(R.id.ratingBarDoctorDetail)?.rating = it.rating!!
            view?.findViewById<TextView>(R.id.txtMedicineDesc)?.text = it.description
            view?.findViewById<TextView>(R.id.txtMedicineID)?.text = it.id
            view?.findViewById<TextView>(R.id.txtStock)?.text = it.dob
            view?.findViewById<TextView>(R.id.txtDosage)?.text = it.age.toString()
            view?.findViewById<TextView>(R.id.txtMinAge)?.text = it.gender
            view?.findViewById<TextView>(R.id.txtMinAge)?.text = it.gender

            val progressBarDetail =  view?.findViewById<ProgressBar>(R.id.progressBarDetail)
            if (progressBarDetail != null) {
                view?.findViewById<ImageView>(R.id.imgMedicineDetail)?.loadImage(it.img.toString(), progressBarDetail)
            }
        })
    }
}