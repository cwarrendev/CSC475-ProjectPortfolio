package com.example.fitnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Switch
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

    private lateinit var notificationsSwitch: Switch


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        notificationsSwitch = view.findViewById(R.id.notificationsSwitch)


        // Example settings values
        notificationsSwitch.isChecked = true


        // Add listeners to handle changes
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle notifications switch change
        }



        return view
    }
}