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
import com.example.healthcare_umc_160420046.model.Schedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoctorScheduleViewModel (application: Application): AndroidViewModel(application) {
    val scheduleLD = MutableLiveData<List<Schedule>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(doctorID : String) {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://umchealthcare.000webhostapp.com/api/schedule.php?doctor_id=$doctorID"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Schedule>>(){}.type
                val result = Gson().fromJson<List<Schedule>>(response, sType)
                scheduleLD.value = result

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