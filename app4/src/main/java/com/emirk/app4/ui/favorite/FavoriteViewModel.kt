package com.emirk.app4.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emirk.app4.data.local.FavoriteDao
import com.emirk.app4.data.local.entity.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val dao: FavoriteDao
) : ViewModel() {

    var personLiveData: MutableLiveData<Person?> = MutableLiveData()

    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        personLiveData.postValue(dao.getPerson())
    }
}