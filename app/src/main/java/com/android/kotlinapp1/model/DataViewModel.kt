package com.android.kotlinapp1.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var index = 0
    val currentIndex: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val currentStatus: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
}