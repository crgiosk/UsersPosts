package com.pruebadeingreso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pruebadeingreso.databinding.ActivityMainBinding
import com.pruebadeingreso.ui.viewmodels.UserPostViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: UserPostViewModel by lazy {
        ViewModelProvider(this)[UserPostViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        navController = findNavController(R.id.main_nav_graph)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}