package com.chirikualii.materidb.ui.search

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chirikualii.materidb.data.local.MovieDbImpl
import com.chirikualii.materidb.data.remote.ApiClient
import com.chirikualii.materidb.data.repository.MovieRepoImpl

class SearchViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val movieDbImpl = MovieDbImpl(context)
        val repo = MovieRepoImpl(ApiClient.service, movieDbImpl)
        val viewModel = SearchViewModel(repo)

        return viewModel as T
    }

}