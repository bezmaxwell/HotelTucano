package com.example.hoteltucano.view.uiMain.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hoteltucano.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navBar:BottomNavigationView = findViewById(R.id.nav_bar_main)

        val navController = findNavController(this,R.id.fragment_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_bar_destaques, R.id.nav_bar_hotel, R.id.nav_bar_packages, R.id.nav_bar_person, R.id.nav_bar_more))

        setupActionBarWithNavController(navController, appBarConfiguration)
            navBar.setupWithNavController(navController)

    }
}













