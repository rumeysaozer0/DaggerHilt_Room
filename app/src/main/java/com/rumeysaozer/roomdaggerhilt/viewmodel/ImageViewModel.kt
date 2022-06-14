package com.rumeysaozer.roomdaggerhilt.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rumeysaozer.roomdaggerhilt.service.NameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(repository: NameRepository): ViewModel() {
val names = repository.getNames().asLiveData()


}