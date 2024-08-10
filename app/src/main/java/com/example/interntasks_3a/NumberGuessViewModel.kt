package com.example.interntasks_3a

import android.content.Context
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberGuessViewModel() : ViewModel() {

    val number = MutableLiveData<Int>()
    val char = MutableLiveData<Char>()
    val result = MutableLiveData<String>()

    init {
        randomNumber()
        randomChar()
    }

    fun randomNumber(){
        val random = (0..9).random()
        number.postValue(random)
    }

    fun randomChar(){
        val random = ('A'..'Z').random()
        char.value = random
    }

    fun guessNumber(guess:Int){
        if (guess == number.value){
            result.value = Constants.RESULT_WIN
        }
        else{
            result.value = Constants.RESULT_TRY_AGAIN
        }
    }
}