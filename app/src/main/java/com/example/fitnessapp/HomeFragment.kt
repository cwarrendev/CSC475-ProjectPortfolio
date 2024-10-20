package com.example.fitnessapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.math.sqrt

class HomeFragment : Fragment(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private lateinit var stepsTextView: TextView
    private lateinit var caloriesTextView: TextView
    private lateinit var milesTextView: TextView
    private lateinit var stepsProgressBar: ProgressBar
    private lateinit var caloriesProgressBar: ProgressBar
    private lateinit var milesProgressBar: ProgressBar
    private var stepCount = 0
    private var lastMagnitude = 0.0
    private val threshold = 6.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        stepsTextView = view.findViewById(R.id.stepsTextView)
        caloriesTextView = view.findViewById(R.id.caloriesTextView)
        milesTextView = view.findViewById(R.id.milesTextView)
        stepsProgressBar = view.findViewById(R.id.stepsProgressBar)
        caloriesProgressBar = view.findViewById(R.id.caloriesProgressBar)
        milesProgressBar = view.findViewById(R.id.milesProgressBar)

        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometer == null) {
            "Accelerometer not available".also { stepsTextView.text = it }
        } else {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        }

        return view
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            if (it.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                val x = it.values[0]
                val y = it.values[1]
                val z = it.values[2]

                val magnitude = sqrt(x * x + y * y + z * z)
                val delta = magnitude - lastMagnitude
                lastMagnitude = magnitude.toDouble()

                if (delta > threshold) {
                    stepCount++
                    stepsTextView.text = "Steps: $stepCount"
                    val caloriesBurned = stepCount * 0.04 // Example calculation
                    val milesWalked = stepCount * 0.0005 // Example calculation
                    caloriesTextView.text = "Calories: %.2f".format(caloriesBurned)
                    milesTextView.text = "Miles: %.2f".format(milesWalked)

                    // Update progress bars
                    stepsProgressBar.progress = stepCount
                    caloriesProgressBar.progress = (caloriesBurned * 100).toInt()
                    milesProgressBar.progress = (milesWalked * 10000).toInt()
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for this implementation
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}