package com.example.interntasks_3a

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var viewModelCounter = 0

    fun counterNumber(){
        viewModelCounter++
    }
}