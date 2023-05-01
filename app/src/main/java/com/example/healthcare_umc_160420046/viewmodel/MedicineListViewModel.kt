package com.example.healthcare_umc_160420046.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.example.healthcare_umc_160420046.model.Medicine
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MedicineListViewModel(application: Application): AndroidViewModel(application) {
    val medicineLD = MutableLiveData<List<Medicine>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh() {
        loadingErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        var url = "https://umchealthcare.000webhostapp.com/api/medicine.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Medicine>>(){}.type
                val result = Gson().fromJson<List<Medicine>>(response, sType)
                medicineLD.value = result

                loadingLD.value = false
                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorLD.value = true
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}