package com.georgcantor.kotlinsamples.rxclick

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import io.reactivex.disposables.Disposable

class RxClickActivity : AppCompatActivity() {

    private val adapter = ListAdapter()
    private var subscribe: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_click)

        setupRecyclerView()
        setupItemClick()
    }

    private fun setupRecyclerView() {
        val recViewList = findViewById<RecyclerView>(R.id.rec_view_list)
        recViewList.layoutManager = LinearLayoutManager(this)
        recViewList.adapter = adapter
    }

    private fun setupItemClick() {
        subscribe = adapter.clickEvent
                .subscribe {
                    Toast.makeText(this, "Выбран: $it", Toast.LENGTH_SHORT).show()
                }
    }

    override fun onDestroy() {
        super.onDestroy()
        subscribe?.dispose()
    }
}
