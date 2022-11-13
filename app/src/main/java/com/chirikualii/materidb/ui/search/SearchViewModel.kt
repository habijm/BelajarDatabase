package com.chirikualii.materidb.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chirikualii.materidb.data.model.Movie
import com.chirikualii.materidb.data.repository.MovieRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(private val repo: MovieRepo) :ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _listMovie = MutableLiveData<List<Movie>>()
    val listMovie : LiveData<List<Movie>> = _listMovie

    fun doSearchMovie(query:String){
        _isLoading.value = true

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val listData = repo.getSearchMovie(query)

                withContext(Dispatchers.Main){
                    _listMovie.value = listData
                    _isLoading.value = false
                }
            }
        }
    }

}