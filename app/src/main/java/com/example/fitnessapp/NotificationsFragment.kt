package com.example.fitnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class NotificationsFragment : Fragment() {

    private lateinit var dailyStepsGoalTextView: TextView
    private lateinit var dailyCaloriesGoalTextView: TextView
    private lateinit var dailyMilesGoalTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        dailyStepsGoalTextView = view.findViewById(R.id.dailyStepsGoalTextView)
        dailyCaloriesGoalTextView = view.findViewById(R.id.dailyCaloriesGoalTextView)
        dailyMilesGoalTextView = view.findViewById(R.id.dailyMilesGoalTextView)

        // Example goal values
        dailyStepsGoalTextView.text = "10000 steps"
        dailyCaloriesGoalTextView.text = "500 calories"
        dailyMilesGoalTextView.text = "5 miles"

        return view
    }
}