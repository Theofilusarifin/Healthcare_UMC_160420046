package com.example.healthcare_umc_160420046.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.healthcare_umc_160420046.model.Medicine
import com.google.gson.Gson

class MedicineDetailViewModel (application: Application): AndroidViewModel(application) {
    val medicineLD = MutableLiveData<Medicine>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(medicineID : String) {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/flutter/160419080/ANMP/ebook.php?id=$medicineID"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Medicine>(response, Medicine::class.java)
                medicineLD.value = result

                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}