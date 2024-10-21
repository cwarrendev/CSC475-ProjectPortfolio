package com.example.fitnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    private lateinit var stepsProgressBar: ProgressBar
    private lateinit var caloriesProgressBar: ProgressBar
    private lateinit var milesProgressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        stepsProgressBar = view.findViewById(R.id.stepsProgressBar)
        caloriesProgressBar = view.findViewById(R.id.caloriesProgressBar)
        milesProgressBar = view.findViewById(R.id.milesProgressBar)

        // TESTING: Set progress values for the progress bars
        stepsProgressBar.progress = 50
        caloriesProgressBar.progress = 30
        milesProgressBar.progress = 20

        return view
    }
}