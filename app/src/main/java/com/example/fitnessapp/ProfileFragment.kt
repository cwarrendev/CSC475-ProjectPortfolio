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
    private lateinit var darkModeSwitch: Switch
    private lateinit var shareDataCheckBox: CheckBox

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        notificationsSwitch = view.findViewById(R.id.notificationsSwitch)
        darkModeSwitch = view.findViewById(R.id.darkModeSwitch)
        shareDataCheckBox = view.findViewById(R.id.shareDataCheckBox)

        // Example settings values
        notificationsSwitch.isChecked = true
        darkModeSwitch.isChecked = false
        shareDataCheckBox.isChecked = false

        // Add listeners to handle changes
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle notifications switch change
        }

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Handle dark mode switch change
        }

        shareDataCheckBox.setOnCheckedChangeListener { _, isChecked ->
            // Handle share data checkbox change
        }

        return view
    }
}