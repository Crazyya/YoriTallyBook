package com.yoriz.yoritallybook.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yoriz.yorizutil.mvvm.BaseViewModel

class HomeViewModel(savedStateHandle: SavedStateHandle) : BaseViewModel(savedStateHandle) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}