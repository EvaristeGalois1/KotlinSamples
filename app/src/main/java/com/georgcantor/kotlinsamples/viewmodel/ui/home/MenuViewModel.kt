package com.georgcantor.kotlinsamples.viewmodel.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.georgcantor.kotlinsamples.viewmodel.model.MenuItem

class MenuViewModel : ViewModel() {

    val repository: MenuRepository = MenuRepository()
    private var menuItems: LiveData<List<MenuItem>>? = null

    fun getMenuItems(): LiveData<List<MenuItem>> {
        if (menuItems == null) {
            menuItems = repository.getMenu()
        }

        return menuItems as LiveData<List<MenuItem>>
    }
}