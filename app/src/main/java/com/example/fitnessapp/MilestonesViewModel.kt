package com.example.fitnessapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MilestonesViewModel : ViewModel() {
    private val _milestones = MutableLiveData<List<Int>>()
    val milestones: LiveData<List<Int>> get() = _milestones

    fun addMilestone(milestone: Int) {
        val currentMilestones = _milestones.value?.toMutableList() ?: mutableListOf()
        currentMilestones.add(milestone)
        _milestones.value = currentMilestones
    }
}