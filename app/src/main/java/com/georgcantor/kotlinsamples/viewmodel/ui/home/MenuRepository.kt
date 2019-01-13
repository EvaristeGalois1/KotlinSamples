package com.georgcantor.kotlinsamples.viewmodel.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.georgcantor.kotlinsamples.viewmodel.model.MenuItem
import com.georgcantor.kotlinsamples.viewmodel.network.RestClient
import com.georgcantor.kotlinsamples.viewmodel.network.RestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuRepository {

    private var restClient: RestService =
            RestClient.getClient().create(RestService::class.java)

    fun getMenu(): LiveData<List<MenuItem>> {
        val data: MutableLiveData<List<MenuItem>> = MutableLiveData()
        val call: Call<List<MenuItem>> = restClient.getMenu()

        call.enqueue(object : Callback<List<MenuItem>> {
            override fun onResponse(call: Call<List<MenuItem>>,
                                    response: Response<List<MenuItem>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<MenuItem>>, t: Throwable) {
                Log.e("MenuRepository", "error: " + t.message)
            }
        })

        return data
    }
}