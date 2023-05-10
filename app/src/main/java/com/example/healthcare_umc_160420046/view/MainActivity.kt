package com.example.healthcare_umc_160420046.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.healthcare_umc_160420046.R
import com.example.healthcare_umc_160420046.viewmodel.ProfileViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var profileViewModel: ProfileViewModel

    private fun showNavigation(){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.VISIBLE

        val navView = findViewById<NavigationView>(R.id.navView)
        navView.visibility = View.VISIBLE
    }

    private fun hideNavigation(){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.visibility = View.GONE
    }

    fun onLoginSuccess(username: String, lastLoginTime: String) {
        profileViewModel.username = username
        profileViewModel.lastLoginTime = lastLoginTime
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(navView,navController)

        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            when(destination.id){
                R.id.loginFragment -> hideNavigation()
                R.id.registerFragment -> hideNavigation()
                else -> showNavigation()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        return NavigationUI.navigateUp(navController,drawerLayout) || super.onSupportNavigateUp()
    }
}