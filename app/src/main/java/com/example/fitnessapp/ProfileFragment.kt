package com.example.fitnessapp

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitnessapp.R.*

class ProfileFragment : Fragment() {

    private lateinit var dbHelper: StepDatabaseHelper
    private lateinit var db: SQLiteDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout.fragment_profile, container, false)
        val resetButton: Button = view.findViewById(R.id.resetButton)

        dbHelper = StepDatabaseHelper(requireContext())
        db = dbHelper.writableDatabase

        resetButton.setOnClickListener {
            resetDatabaseValues()
            Toast.makeText(requireContext(), "Data reset successfully", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private fun resetDatabaseValues() {
        val values = ContentValues().apply {
            put(StepDatabaseHelper.COLUMN_STEPS, 0)
        }
        db.update(StepDatabaseHelper.TABLE_NAME, values, null, null)
    }
}