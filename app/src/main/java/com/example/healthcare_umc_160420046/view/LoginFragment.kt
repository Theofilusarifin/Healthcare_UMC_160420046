package com.example.healthcare_umc_160420046.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.healthcare_umc_160420046.R
import java.text.SimpleDateFormat
import java.util.Locale

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val txtUsername = view.findViewById<TextView>(R.id.txtUsername)

        btnLogin.setOnClickListener {
            val username = txtUsername.text.toString()
            val lastLoginTime: String = SimpleDateFormat("dd-MMM-yyyy HH:mm", Locale.US).format(System.currentTimeMillis())

            (requireActivity() as MainActivity).onLoginSuccess(username, lastLoginTime)

            val action = LoginFragmentDirections.actionLoginToDoctorList()
            Navigation.findNavController(it).navigate(action)
        }
    }
}