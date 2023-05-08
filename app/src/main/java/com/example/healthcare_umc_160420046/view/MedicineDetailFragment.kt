package com.example.healthcare_umc_160420046.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.util.loadImage
import com.example.healthcare_umc_160420046.viewmodel.MedicineDetailViewModel

class MedicineDetailFragment : Fragment() {
    private lateinit var viewModel: MedicineDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val medicineID = MedicineDetailFragmentArgs.fromBundle(requireArguments()).medicineID

        viewModel = ViewModelProvider(this)[MedicineDetailViewModel::class.java]
        viewModel.fetch(medicineID)

        observeViewModel()
    }

    @SuppressLint("SetTextI18n")
    private fun observeViewModel() {
        viewModel.medicineLD.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextView>(R.id.txtMedicineNameDetail)?.text = it.name
            view?.findViewById<TextView>(R.id.txtPriceDetail)?.text = "Rp.${it.price.toString()}"
            view?.findViewById<TextView>(R.id.txtMedicineDesc)?.text = it.description
            view?.findViewById<TextView>(R.id.txtMedicineID)?.text = it.id
            view?.findViewById<TextView>(R.id.txtStock)?.text = it.stock.toString()
            view?.findViewById<TextView>(R.id.txtDosage)?.text = it.dosage
            view?.findViewById<TextView>(R.id.txtMinAge)?.text = it.min_age.toString() + " Years"

            val progressBarDetail =  view?.findViewById<ProgressBar>(R.id.progressBarDetail)
            if (progressBarDetail != null) {
                view?.findViewById<ImageView>(R.id.imgMedicineDetail)?.loadImage(it.img.toString(), progressBarDetail)
            }
        })
    }
}