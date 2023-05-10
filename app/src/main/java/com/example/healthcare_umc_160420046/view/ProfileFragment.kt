package com.example.healthcare_umc_160420046.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {
    lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]

        val txtusername = view.findViewById<TextView>(R.id.username)
        val txtlastlogin = view.findViewById<TextView>(R.id.last_login)

        profileViewModel.username?.let { txtusername.text = it }
        profileViewModel.lastLoginTime?.let { txtlastlogin.text = it }
    }
}