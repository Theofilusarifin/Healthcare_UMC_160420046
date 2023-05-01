package com.example.healthcare_umc_160420046.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.healthcare_umc_160420046.model.Doctor
import com.google.gson.Gson

class DoctorDetailViewModel (application: Application): AndroidViewModel(application) {
    val doctorLD = MutableLiveData<Doctor>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(doctorID : String) {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://umchealthcare.000webhostapp.com/api/doctor.php?doctor_id=$doctorID"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Doctor>(response, Doctor::class.java)
                doctorLD.value = result

                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}