package com.emirk.app4.ui.home

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
class HomeViewModel @Inject constructor(
    private val dao: FavoriteDao
) : ViewModel() {

    var personLiveData: MutableLiveData<Person?> = MutableLiveData()

    fun save(person: Person) = viewModelScope.launch {
        dao.save(person)
    }

    fun delete(id: Int) = viewModelScope.launch {
        dao.deletePerson(id)
    }

    fun getPerson() = viewModelScope.launch(Dispatchers.IO) {
        personLiveData.postValue(dao.getPerson())
    }
}