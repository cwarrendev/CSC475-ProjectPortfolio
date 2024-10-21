package com.example.fitnessapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class NotificationsFragment : Fragment() {

    private lateinit var milestonesLayout: LinearLayout
    private lateinit var viewModel: MilestonesViewModel
    private lateinit var noNotificationsTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        milestonesLayout = view.findViewById(R.id.milestonesLayout)
        noNotificationsTextView = view.findViewById(R.id.noNotificationsTextView)
        viewModel = ViewModelProvider(requireActivity()).get(MilestonesViewModel::class.java)

        viewModel.milestones.observe(viewLifecycleOwner) { milestones ->
            milestonesLayout.removeAllViews()
            if (milestones.isEmpty()) {
                noNotificationsTextView.visibility = View.VISIBLE
                milestonesLayout.visibility = View.GONE
            } else {
                noNotificationsTextView.visibility = View.GONE
                milestonesLayout.visibility = View.VISIBLE
                milestones.forEach { milestone ->
                    val milestoneTextView = TextView(requireContext()).apply {
                        "Milestone Achieved: $milestone steps!".also { text = it }
                        textSize = 16f
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    }
                    milestonesLayout.addView(milestoneTextView)
                }
            }
        }

        return view
    }
}