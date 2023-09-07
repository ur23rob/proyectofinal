package com.android.app.pfi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val comparisonResult = MutableLiveData<Boolean>()

    fun getComparisonResult(): LiveData<Boolean> = comparisonResult

    fun compareTexts(text1: String, text2: String) {
        val areEqual = text1 == text2
        comparisonResult.value = areEqual
    }
}
